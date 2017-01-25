package edu.washington.swifties.lifecounter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

  private TextView player1Life, player2Life, player3Life, player4Life;

  public static final int BUTTON_COUNT = 16;

  private int count1, count2, count3, count4;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    int[] buttonIds = {
        R.id.player1Minus,
        R.id.player1Minus5,
        R.id.player2Minus,
        R.id.player2Minus5,
        R.id.player3Minus,
        R.id.player3Minus5,
        R.id.player4Minus,
        R.id.player4Minus5,
        R.id.player1Plus,
        R.id.player1Plus5,
        R.id.player2Plus,
        R.id.player2Plus5,
        R.id.player3Plus,
        R.id.player3Plus5,
        R.id.player4Plus,
        R.id.player4Plus5,
    };

    Button[] buttons = new Button[BUTTON_COUNT];
    for (int i = 0; i < BUTTON_COUNT; i++) {
      buttons[i] = (Button) findViewById(buttonIds[i]);
      buttons[i].setOnClickListener(this);
    }

    player1Life = (TextView) findViewById(R.id.player1lifeTextView);
    player2Life = (TextView) findViewById(R.id.player2lifeTextView);
    player3Life = (TextView) findViewById(R.id.player3lifeTextView);
    player4Life = (TextView) findViewById(R.id.player4lifeTextView);

    count1 = 20;
    count2 = 20;
    count3 = 20;
    count4 = 20;

  }


  @Override
  public void onClick(View v) {
    int id = v.getId();
    if (id == R.id.player1Minus) {
      count1--;
    } else if (id == R.id.player1Minus5) {
      count1 -= 5;
    } else if (id == R.id.player2Minus) {
      count2--;
    } else if (id == R.id.player2Minus5) {
      count2 -= 5;
    } else if (id == R.id.player3Minus) {
      count3--;
    } else if (id == R.id.player3Minus5) {
      count3 -= 5;
    } else if (id == R.id.player4Minus) {
      count4--;
    } else if (id == R.id.player4Minus5) {
      count4 -= 5;
    } else if (id == R.id.player1Plus) {
      count1++;
    } else if (id == R.id.player1Plus5) {
      count1 += 5;
    } else if (id == R.id.player2Plus) {
      count2++;
    } else if (id == R.id.player2Plus5) {
      count2 += 5;
    } else if (id == R.id.player3Plus) {
      count3++;
    } else if (id == R.id.player3Plus5) {
      count3 += 5;
    } else if (id == R.id.player4Plus) {
      count4++;
    } else if (id == R.id.player4Plus5) {
      count4 += 5;
    }
    player1Life.setText("" + count1);
    player2Life.setText("" + count2);
    player3Life.setText("" + count3);
    player4Life.setText("" + count4);
    String message = "";
    boolean showMessage = false;
    if (count1 <= 0) {
      message = "Player 1 loses!";
      showMessage = true;
    } else if (count2 <= 0) {
      message = "Player 2 loses!";
      showMessage = true;
    } else if (count3 <= 0) {
      message = "Player 3 loses!";
      showMessage = true;
    } else if (count4 <= 0) {
      message = "Player 4 loses!";
      showMessage = true;
    }
    if (showMessage) {
      Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
  }
}
