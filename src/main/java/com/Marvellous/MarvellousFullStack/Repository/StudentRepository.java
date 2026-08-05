package com.Marvellous.MarvellousFullStack.Repository;

import com.Marvellous.MarvellousFullStack.Entity.StudentEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository
        extends MongoRepository<StudentEntry, ObjectId> {

}