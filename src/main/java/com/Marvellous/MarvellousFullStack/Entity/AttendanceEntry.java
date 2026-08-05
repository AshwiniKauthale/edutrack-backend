package com.Marvellous.MarvellousFullStack.Entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "AttendanceDetails")
@Getter
@Setter
public class AttendanceEntry {

    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;

    private String studentName;

    private String batchName;

    private String date;

    private String status;
}