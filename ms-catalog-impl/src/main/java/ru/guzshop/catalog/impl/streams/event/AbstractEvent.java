package ru.guzshop.catalog.impl.streams.event;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;

@Getter
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    property = "type"
)
@JsonSubTypes({
    @JsonSubTypes.Type(value = FirstEvent.class, name = "first"),
    @JsonSubTypes.Type(value = SecondEvent.class, name = "second")
})
public class AbstractEvent {

}
