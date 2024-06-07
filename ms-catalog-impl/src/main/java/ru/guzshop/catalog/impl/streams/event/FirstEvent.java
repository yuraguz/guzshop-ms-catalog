package ru.guzshop.catalog.impl.streams.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;

@Getter
@JsonTypeName("first")
public class FirstEvent extends AbstractEvent {

    private String name;

    public FirstEvent(@JsonProperty("name") String name) {
        this.name = name;
    }
}
