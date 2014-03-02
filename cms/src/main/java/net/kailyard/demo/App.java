package net.kailyard.demo;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.mongodb.util.JSON;

public class App {
    public static void main(String[] args) {
        
        try {
 
            Mongo mongo = new Mongo("172.16.2.13", 27017);
            DB db = mongo.getDB("test");
            DBCollection collection = db.getCollection("test");
 
            // convert JSON to DBObject directly
            DBObject dbObject = (DBObject) JSON
                    .parse("{'name':'mkyong', 'age':30}");
 
            collection.insert(dbObject);
 
            DBCursor cursorDoc = collection.find();
            while (cursorDoc.hasNext()) {
                System.out.println(cursorDoc.next());
            }
 
            System.out.println("Done");
 
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }
}
