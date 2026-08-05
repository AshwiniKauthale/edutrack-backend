package com.Marvellous.MarvellousFullStack.Repository;

import com.Marvellous.MarvellousFullStack.Entity.AssignmentEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignmentRepository
        extends MongoRepository<AssignmentEntry, ObjectId> {
}