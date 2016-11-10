package cardinalhealth.dbget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.json.JSONException;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((Button) findViewById(R.id.download_btn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getTheDbs(new Runnable(){
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable(){
                            @Override
                            public void run() {
                                Toast.makeText(getApplicationContext(), "Done!!!", Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                });
            }
        });
    }

    private void getTheDbs(Runnable runnable) {
        try {
            new Getter().getAllDataBases(runnable);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
