# MS-SKELETON. Шаблон для микросервисов, написанных на Java

## Общие сведения

Данный репозиторий используется в качестве шаблона при создании новых микросервисов,
а также демонстрации работы с различными технологиями, правил кодирования и т.д.

## Правила разработки 

С основными правилами и положениями по разработке микросервисов можно 
ознакомиться в вики на странице 
["Java. Основные концепции разработки"](https://piin.atlassian.net/wiki/spaces/ARCHI/pages/23396397/Java.)

### В данном репозитории демонстрируются:

- Структура модулей / пакетов / классов и требуемых файлов конфигурации в соответствии с [требованиями](https://piin.atlassian.net/wiki/spaces/ARCHI/pages/11665410).
- Работа с REST контроллерами в соответствии с [требованиями](https://piin.atlassian.net/wiki/spaces/ARCHI/pages/23789595/API+REST).
- Работа с асинхронным API (Kafka) в соответствии с [требованиями](https://piin.atlassian.net/wiki/spaces/ARCHI/pages/23330930/API+kafka).
- Работа с БД в соответствии с [требованиями](https://piin.atlassian.net/wiki/spaces/ARCHI/pages/23396473).
- Примеры использования фасадов и адаптеров в соответствии с [требованиями](https://piin.atlassian.net/wiki/spaces/ARCHI/pages/23756831).
- Примеры написания IT и Unit тестов в соответствии с [требованиями](https://piin.atlassian.net/wiki/spaces/ARCHI/pages/23429171).
- Примеры использования библиотек в соответствии с [требованиями](https://piin.atlassian.net/wiki/spaces/ARCHI/pages/23232576).
- Соблюдение сheckstyle и codestyle в соответствии с [требованиями](https://piin.atlassian.net/wiki/spaces/ARCHI/pages/32473137/Checkstyle).

## Инструкция по запуску ms-skeleton на локальной машине

### 1. Клонирование проекта

    git clone git@napolke.gitlab.yandexcloud.net:napolke/backend/ms-skeleton.git

### 2. Поднятие внешних систем через docker-compose

Приложение взаимодействует с различными внешними системами, такими как база данных,
брокер сообщений и т.д. Все необходимые зависимости можно поднять в docker контейнерах
через файл `docker-compose.yml`. Для запуска docker-compose необходимо в любом
терминале (можно прямо в IDE) перейти в папку с расположением файла по пути `/local/ci/start` относительно
корня проекта и ввести следующую команду:

    docker-compose up

Для остановки всех запущенных контейнеров можно использовать следующую команду:

    docker-compose down

После поднятия всех требуемых зависимостей в докер контейнерах проект готов к запуску.

> ### Примечание
> В Intellij IDEA Ultimate edition запустить файл docker-compose.yml можно прямо
> находясь в соответствующем файле нажав на зеленый значек-стрелочку.

### 3. Запуск проекта

Запуск проекта осуществляется стандартным способом через IDE (никаких явных указаний
используемого активного профиля не нужно).

## Инструкция по созданию нового сервиса на базе репозитория ms-skeleton 

### 1. Клонирование проекта

    git clone git@napolke.gitlab.yandexcloud.net:napolke/backend/ms-skeleton.git

### 2. Настройка GitLab CI / CD

1. Переместить файл из `ms-skeleton/local/ci/.gitlab-ci.yml` в `ms-skeleton/`
(папку `ms-skeleton/local/ci` нужно удалить за ненадобностью)
2. В файле `.gitlab-ci.yml` заменить все вхождения `ms-skeleton` на название нового сервиса (пример `ms-order`)

### 3. Настрока Dockerfile
В Dockerfile необходимо заменить все вхождения `ms-skeleton` на название нового сервиса (пример `ms-order`)

>В зависимости от требований при сборке docker image может понадобиться установить дополнительные
>сертификаты безопасности (или что-то другое). Ниже представлен пример Dockerfile c установкой сертификата YandexInternalRootCA.
>```
>FROM openjdk:17-slim
>ENV TZ="Europe/Moscow"
>
>RUN apt-get update -y && apt-get install wget -y && mkdir --parents /usr/local/share/ca-certificates/Yandex && mkdir --parents ~/.postgresql && wget "https://storage.yandexcloud.net/cloud-certs/CA.pem" --output-document ~/.postgresql/root.crt && cp ~/.postgresql/root.crt /usr/local/share/ca-certificates/Yandex/YandexInternalRootCA.crt \
> && chmod 0600 ~/.postgresql/root.crt  && chmod 655 /usr/local/share/ca-certificates/Yandex/YandexInternalRootCA.crt && cd /etc/security && \
>> keytool -importcert -alias YandexCA -file /usr/local/share/ca-certificates/Yandex/YandexInternalRootCA.crt \
>     -keystore ssl -storepass {password} --noprompt
>
>COPY ms-skeleton-impl/target/*.jar ms-skeleton.jar
>ENTRYPOINT exec java $JAVA_ARG -jar /ms-skeleton.jar
>```

### 4. Настройка параметров окружения для k8s

В конфигурационных файлах `ms-napolke/values-*.yaml`, каждый из которых 
соответствует определенному стенду, необходимо указать:

1. Namespace, в который будет деплоиться сервис в кластере k8s (по умолчанию `np-backend`)
2. Количество используемой памяти и ядер процессора (зависит от степени нагруженности сервиса)
3. Количество реплик / подов (за это отвечает параметр `replicaCount`)

### 5. Удаление модуля ms-skeleton-external-api
Модуль `ms-skeleton-external-api` используется исключительно для демонстрации работы 
с фасадами и адаптерами. В связи с этим его нужно отключить и удалить из проекта.

### 6. Переименование модулей / mavеn артефактов / пакетов и классов

Переименование потребуется произвести:
- Для всех модулей в проекте (к примеру `ms-skeleton-api` заменить на `ms-order-api` и т.д.)
- Во всех `pom.xml` файлах, где присутствует вхождение `skeleton` в названии артефактов, а также в подключаемых зависимостях.
- Для пакетов `skeleton` по всех модулях (к примеру пакет пути `/srs/main/java/ru/napolke/skeleton/**` переименовать на `/src/main/java/ru/napolke/order/**`)

После выполнения всех вышеперечисленных пунктов через глобальный поиск по проекту
необходимо убедиться, что вхождение `skeleton` нигде не присутствует.

### 7. Удаление ненужных модулей / компонентов / зависимостей / классов

В проекте ms-skeleton присутствует большое количество различных модулей, классов 
и зависимостей для демонстрационных целей. Для нового микросервиса большинство из
этих артефактов может не понадобиться, поэтому необходимо удалить все то лишнее,
что не будет использоваться в проекте.

> Для удобности все классы и методы, потенциально пригодные для удаления
> в java doc комментариях отмечены как `(FOR DEMONSTRATION)`

### 8. Настройка checkstyle

Настройка checkstyle в проекте осуществляется в соответствии с описанием в [статье в вики](https://napolke.gitlab.yandexcloud.net/napolke/wiki/-/wikis/backend/java/codequality)
