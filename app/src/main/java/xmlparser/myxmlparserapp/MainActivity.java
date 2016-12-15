package xmlparser.myxmlparserapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.StringReader;

public class MainActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            testXML();
        } catch (Exception e) {
            Log.v("MUMU", e.getMessage());
        }


    void testXML() throws XmlPullParserException, IOException

    {
        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        factory.setNamespaceAware(true);
        XmlPullParser xpp = factory.newPullParser();

        xpp.setInput(new StringReader("<foo>Hello World!</foo>"));
        int eventType = xpp.getEventType();
        while (eventType != XmlPullParser.END_DOCUMENT) {
            if (eventType == XmlPullParser.START_DOCUMENT) {
                Log.v("MUMU", "Start document");
            } else if (eventType == XmlPullParser.START_TAG) {
                Log.v("MUMU", "Start tag " + xpp.getName());
            } else if (eventType == XmlPullParser.END_TAG) {
                Log.v("MUMU", "End tag " + xpp.getName());
            } else if (eventType == XmlPullParser.TEXT) {
                Log.v("MUMU", "Text " + xpp.getText());
            }
            eventType = xpp.next();
        }
        Log.v("MUMU", "End document");


    }
   
    }

}
