package com.Marvellous.MarvellousFullStack.Repository;

import com.Marvellous.MarvellousFullStack.Entity.ClassroomEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassroomRepository extends MongoRepository<ClassroomEntry, ObjectId> {
}