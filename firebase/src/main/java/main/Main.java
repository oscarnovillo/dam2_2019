package main;


import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        // Fetch the service account key JSON file contents
        FileInputStream serviceAccount = new FileInputStream("entornosquevedo-firebase-adminsdk-rj2kv-9fab8bb811.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://entornosquevedo.firebaseio.com/")
                .build();
        FirebaseApp.initializeApp(options);





// The app only has access to public data as defined in the Security Rules
        DatabaseReference ref = FirebaseDatabase
                .getInstance()
                .getReference("clientes");
        //ref.getKey();



//          ref.addChildEventListener(new ChildEventListener() {
//
//            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
//                String dinosaur = (String) dataSnapshot.getValue();
//                System.out.println(dataSnapshot.getKey() + " was " + dinosaur + " meters tall.");
//            }
//
//
//            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
//                String dinosaur = (String) dataSnapshot.getValue();
//                System.out.println(dataSnapshot.getKey() + " was " + dinosaur + " meters tall.");
//            }
//
//
//            public void onChildRemoved(DataSnapshot dataSnapshot) {
//
//            }
//
//
//            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });

        ref.addValueEventListener(new ValueEventListener() {

            public void onDataChange(DataSnapshot dataSnapshot) {
                //String res = (String) dataSnapshot.getChildrenCount();
                System.out.println(dataSnapshot.getValue());
            }


            public void onCancelled(DatabaseError databaseError) {
                System.out.println(databaseError.getMessage());
            }
        });


        Scanner sc = new Scanner(System.in);
        while (!sc.hasNext())
            Thread.sleep(1000);
    }
}
