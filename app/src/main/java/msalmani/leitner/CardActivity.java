package msalmani.leitner;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CardActivity extends AppCompatActivity {

    TextView back;
    View divider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        back = (TextView)findViewById(R.id.BackCardTxt);
        divider = (View)findViewById(R.id.Divider);
    }

    public void FrontCard(View view){
        if (back.getVisibility() == View.GONE){

            back.setVisibility(View.VISIBLE);
            divider.setVisibility(View.VISIBLE);
        }

    }

    public void backward(View view){


    }

    public void forward(View view){


    }

    public void dunnoBtn(View view){


    }

    public void knowBtn(View view){


    }

}
