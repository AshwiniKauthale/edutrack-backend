package com.Marvellous.MarvellousFullStack.Entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "BatchDetails")
@Getter
@Setter
public class BatchEntry
{
    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    private String id;
    private String name;
    private int fees;
    private String trainer;
    private int duration;
    private String description;
}
