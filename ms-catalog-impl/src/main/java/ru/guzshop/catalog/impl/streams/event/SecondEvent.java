package ru.guzshop.catalog.impl.streams.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;

@Getter
@JsonTypeName("second")
public class SecondEvent extends AbstractEvent {

    private String name;

    public SecondEvent(@JsonProperty("name") String name) {
        this.name = name;
    }

}
