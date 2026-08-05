package com.Marvellous.MarvellousFullStack.Repository;

import com.Marvellous.MarvellousFullStack.Entity.AdminProfile;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AdminProfileRepository
        extends MongoRepository<AdminProfile, ObjectId> {
}