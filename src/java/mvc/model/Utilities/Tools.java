/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model.Utilities;

import java.time.LocalDate;
import javafx.animation.Animation;

/**
 *
 * @author Kareem E.Farouk
 */
public class Tools {
    public void timer()
{
int hours=0,minutes=0,seconds=0;
while(minutes<15)
{
  //status.setText("Time:  "  + hours + ":" + minutes + ":" + seconds);
  try
  {
  Thread.sleep(1000);
  }
  catch(Exception e)
  {
  }
  seconds++;
  if(seconds==60)
  {
        minutes++;
        seconds=0;
  }
  if(minutes==60)
  {
        hours++;
        minutes=0;
  }
}
//submit();
}
    public String getDate(){
        String x = "";
        LocalDate ld = java.time.LocalDate.now();
        x = ld.toString();
        return x;
    }
}
