package com.example.Student.DBModel;

import org.bson.types.ObjectId;
import javax.validation.constraints.NotEmpty;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Index;
import org.mongodb.morphia.annotations.Indexes;
import org.mongodb.morphia.annotations.Property;

@Entity("student")
@Indexes( {
    @Index( "LastName, FirstName" )
} )
public class StudentDTOModel {
	//@Id private  ObjectId id;
	@Property @NotEmpty private  String FirstName;
	@Property @NotEmpty private String LastName;

    public StudentDTOModel() {
       
    }

//    public ObjectId getId() {
//        return id;
//    }
//     
//    protected void setId( ObjectId id ) {
//        this.id = id;
//    }

    public String getFirstName() {
        return FirstName;
    }
    
    public String getLastName() {
        return LastName;
    }
    
    public void setFirstName( final String firstName ) {
        this.FirstName = firstName;
    }
  
    
    public void setLastName( String lastName ) {
        this.LastName = lastName;
    }
}
