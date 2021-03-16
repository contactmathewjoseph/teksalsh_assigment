# RetroNews

## Project Requirements : [By Tribe3 of War Consulting LLC] 

Summary: You have been hired as an Android developer to create a functioning application for a client that wants to keep track of headlines of newspaper articles and compile them into a single application.

Step One: You are asked to identify a minimum of four news websites (Since this is an exercise and not an actual project, you may use any four news websites of your choice, examples include 'The Daily Star', 'Prothom Alo', 'The Daily Ittefaq' etc. 

Step Two: You must develop an android application that will be able to map the top headlines from your website and list them in a single page.

Step Three: Your application must ensure the links are refreshed every 2-3 hours reflecting the latest headlines. 

Parameters:

1.	The 'view page' or 'user page' should have a heading for each newspaper website using the name of the newspaper. 
2.	Under the title of the newspaper you should route the top 5 headlines of that newspaper.
3.	The headlines should be refreshed every 3 hours.
Below is an example of what the user page should contain:

The Daily Star (This is the title)
1. First Headline (Active Link)
2. Second Headline (Active Link)
3. Third Headline (Active Link)
4. Fourth Headline (Active Link)
5. Fifth Headline (Active Link)

Prothom Alo (This is the title)
1. First Headline (Active Link)
2. Second Headline (Active Link)
3. Third Headline (Active Link)
4. Fourth Headline (Active Link)
5. Fifth Headline (Active Link)


Please feel free to use any resources available at your disposal, you may collaborate with your colleagues as well. This is an exercise replicating an actual client request, hence we expect the deliverable to be done in a timely fashion. 


### Dependencies used : 


    implementation fileTree(dir: 'libs', include: ['*.jar'])
    implementation 'com.android.support:appcompat-v7:29.0.0'
    implementation 'com.android.support:design:29.0.0'
    implementation 'com.android.support.constraint:constraint-layout:1.1.3'
    implementation 'androidx.appcompat:appcompat:1.1.0'
    implementation 'androidx.constraintlayout:constraintlayout:1.1.3'
    implementation 'com.google.firebase:firebase-core:17.2.1'
    implementation 'com.google.firebase:firebase-database:19.2.0'
    implementation 'com.google.firebase:firebase-auth:19.2.0'
    implementation 'com.google.firebase:firebase-firestore:21.3.1'
    implementation 'com.google.firebase:firebase-storage:19.1.0'
    implementation 'androidx.legacy:legacy-support-v4:1.0.0'
    implementation 'com.google.android.material:material:1.1.0'
    implementation 'androidx.navigation:navigation-fragment:2.0.0'
    implementation 'androidx.navigation:navigation-ui:2.0.0'
    implementation 'androidx.lifecycle:lifecycle-extensions:2.2.0'
    testImplementation 'junit:junit:4.12'
    androidTestImplementation 'androidx.test.ext:junit:1.1.0'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.1.1'
    implementation('com.github.ViksaaSkool:AwesomeSplash:v1.0.0') {
        exclude group: 'com.android.support'
    }
    implementation 'com.google.firebase:firebase-analytics:17.2.1'
    implementation 'com.android.support:multidex:1.0.3'
    implementation 'com.facebook.android:facebook-android-sdk:[5,6)'
    implementation 'com.github.bumptech.glide:glide:4.11.0'
    annotationProcessor 'com.github.bumptech.glide:compiler:4.11.0'

    implementation 'com.facebook.android:facebook-login:[5,6)'
    //noinspection GradleCompatible
    implementation 'com.android.support:cardview-v7:28.0.0'
    //noinspection GradleCompatible
    implementation 'com.android.support:customtabs:28.0.0'
    //noinspection GradleCompatible
    implementation 'com.android.support:support-media-compat:28.0.0'
    //noinspection GradleCompatible
    implementation 'com.android.support:support-v4:28.0.0'

    implementation 'com.google.android.gms:play-services-auth:17.0.0'

    //noinspection GradleCompatible
    implementation "com.android.support:support-core-utils:28.0.0"

    //noinspection GradleCompatible
    implementation 'com.android.support:support-core-ui:28.0.0'

    //noinspection GradleCompatible
    implementation 'com.android.support:support-media-compat:28.0.0'

    //noinspection GradleCompatible
    implementation 'com.android.support:support-media-compat:28.0.0'

    //noinspection GradleCompatible
    implementation 'com.android.support:support-fragment:28.0.0'

    //noinspection GradleCompatible
    implementation 'com.android.support:appcompat-v7:28.0.0'

    // FirebaseUI for Firebase Realtime Database
    implementation 'com.firebaseui:firebase-ui-database:6.2.0'

    // FirebaseUI for Cloud Firestore
    implementation 'com.firebaseui:firebase-ui-firestore:6.2.0'

    // FirebaseUI for Firebase Auth
    // implementation 'com.firebaseui:firebase-ui-auth:6.2.0'

    implementation 'com.firebase:firebase-client-android:2.5.2'

    // FirebaseUI for Cloud Storage
    implementation 'com.firebaseui:firebase-ui-storage:6.2.0'

    implementation 'com.android.support:recyclerview-v7:29.0.0'
    implementation 'com.android.support:cardview-v7:29.0.0'
    implementation 'com.google.android.gms:play-services-nearby:17.0.0'

    implementation 'com.android.support:support-v4:+'
    implementation 'com.android.support:appcompat-v7:+'
    implementation 'com.google.android.gms:play-services-basement:15.0.1'
    implementation 'com.google.android.gms:play-services-base:15.0.1'
    implementation 'com.google.android.gms:play-services-gcm:15.0.1'
    implementation 'com.google.android.gms:play-services-location:15.0.1'

    implementation 'com.google.android.gms:play-services-maps:16.0.0'

    implementation 'com.github.androdocs:Simple-HTTP-Request:v1.0'
    implementation 'org.adblockplus:adblock-android-webview:3.14'
