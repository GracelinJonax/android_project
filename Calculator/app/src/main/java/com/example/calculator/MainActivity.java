package com.example.calculator;
import java.util.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.*;

public class MainActivity extends AppCompatActivity {
    Button one,two,three,four,five,six,seven,eight,nine,zero,ac,openbr,closebr,mul,sub,add,dot,equal;
    ImageButton div,del;
    EditText edit;
    String z,text,final_ans;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        one=(Button)findViewById(R.id.one);
        two=findViewById(R.id.two);
        three=findViewById(R.id.three);
        four=findViewById(R.id.four);
        five=findViewById(R.id.five);
        six=findViewById(R.id.six);
        seven=findViewById(R.id.seven);
        eight=findViewById(R.id.eight);
        nine=findViewById(R.id.nine);
        zero=findViewById(R.id.zero);
        add=findViewById(R.id.add);
        sub=findViewById(R.id.sub);
        mul=findViewById(R.id.mul);
        div=findViewById(R.id.div);
        equal=findViewById(R.id.equal);
        del=findViewById(R.id.del);
        ac=findViewById(R.id.ac);
        openbr=findViewById(R.id.openbr);
        closebr=findViewById(R.id.closebr);
        dot=findViewById(R.id.dot);
        edit=findViewById(R.id.display);

        one.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                edit.setText(edit.getText() + "1");
            }
        });
        two.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                edit.setText(edit.getText()+"2");
            }
        });
        three.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                edit.setText(edit.getText()+"3");
            }
        });
        four.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                edit.setText(edit.getText()+"4");
            }
        });
        five.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                edit.setText(edit.getText()+"5");
            }
        });
        six.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                edit.setText(edit.getText()+"6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                edit.setText(edit.getText()+"7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                edit.setText(edit.getText()+"8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                edit.setText(edit.getText()+"9");
            }
        });
        zero.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                edit.setText(edit.getText()+"0");
            }
        });
        openbr.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                edit.setText(edit.getText()+"(");
            }
        });
        closebr.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                edit.setText(edit.getText()+")");
            }
        });
        dot.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                edit.setText(edit.getText()+".");
            }
        });
        div.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(edit.getText().length()==0)
                    edit.setText("");
                else
                edit.setText(edit.getText()+"/");
            }
        });
        mul.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(edit.getText().length()==0)
                    edit.setText("");
                else
                    edit.setText(edit.getText()+"X");
            }
        });
        add.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(edit.getText().length()==0)
                    edit.setText("");
                else
                    edit.setText(edit.getText()+"+");
            }
        });
        sub.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(edit.getText().length()==0)
                    edit.setText("");
                else
                    edit.setText(edit.getText()+"-");
            }
        });
        del.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(edit.getText().length()==0)
                    edit.setText("");
                else{
                   z=""+edit.getText();
                    edit.setText(z.substring(0,z.length()-1));
                }

            }
        });
        ac.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                edit.setText("");
            }
        });
        equal.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(edit.getText().length()==0)
                    edit.setText("");
                else{
                    text=""+edit.getText();
                while(true){
                            if(text.contains(")")){
                                int cind=text.indexOf(")");
                                String temp=text.substring(0,cind);
                                int oind=temp.lastIndexOf("(");
                                temp=temp.substring(oind+1,temp.length());
                                text=text.substring(0,oind)+bod(temp)+text.substring(cind+1,text.length());
                            }
                            else{
                                final_ans=bod(text);
                                edit.setText(final_ans);
                                break;
                            }
                        }
                    }
                }
            public String bod(String temp){
                while(temp.contains("/")||temp.contains("X")||temp.contains("-")||temp.contains("+")){
                    if(temp.contains("/")){
                        int ind=temp.indexOf("/");
                        String n1="",n2="";
                        int first=0,last=0;
                        for(int i=ind-1;i>=0;i--){
                            if(!Character.isDigit(temp.charAt(i))&&temp.charAt(i)!='.')
                                break;
                            n1=""+temp.charAt(i)+n1;
                            first=i;
                        }
                        for(int i=ind+1;i<temp.length();i++){
                            if(!Character.isDigit(temp.charAt(i))&&temp.charAt(i)!='.')
                                break;
                            n2=n2+temp.charAt(i);
                            last=i;
                        }
                        String ans=""+((Float.parseFloat(n1))/(Float.parseFloat(n2)));
                        temp=temp.substring(0,first)+ans+temp.substring(last+1,temp.length());
                    }
                    else if(temp.contains("X")){
                        int ind=temp.indexOf("X");
                        String n1="",n2="";
                        int first=0,last=0;
                        for(int i=ind-1;i>=0;i--){
                            if(!Character.isDigit(temp.charAt(i))&&temp.charAt(i)!='.')
                                break;
                            n1=""+temp.charAt(i)+n1;
                            first=i;
                        }
                        for(int i=ind+1;i<temp.length();i++){
                            if(!Character.isDigit(temp.charAt(i))&&temp.charAt(i)!='.')
                                break;
                            n2=n2+temp.charAt(i);
                            last=i;
                        }
                        String ans=""+((Float.parseFloat(n1))*(Float.parseFloat(n2)));
                        temp=temp.substring(0,first)+ans+temp.substring(last+1,temp.length());
                    }
                    else if(temp.contains("-")){
                        int ind=temp.indexOf("-");
                        String n1="",n2="";
                        int first=0,last=0;
                        for(int i=ind-1;i>=0;i--){
                            if(!Character.isDigit(temp.charAt(i))&&temp.charAt(i)!='.')
                                break;
                            n1=""+temp.charAt(i)+n1;
                            first=i;
                        }
                        for(int i=ind+1;i<temp.length();i++){
                            if(!Character.isDigit(temp.charAt(i))&&temp.charAt(i)!='.')
                                break;
                            n2=n2+temp.charAt(i);
                            last=i;
                        }
                        String ans=""+((Float.parseFloat(n1))-(Float.parseFloat(n2)));
                        temp=temp.substring(0,first)+ans+temp.substring(last+1,temp.length());
                    }
                    else if(temp.contains("+")){
                        int ind=temp.indexOf("+");
                        String n1="",n2="";
                        int first=0,last=0;
                        for(int i=ind-1;i>=0;i--){
                            if(!Character.isDigit(temp.charAt(i))&&temp.charAt(i)!='.')
                                break;
                            n1=""+temp.charAt(i)+n1;
                            first=i;
                        }
                        for(int i=ind+1;i<temp.length();i++){
                            if(!Character.isDigit(temp.charAt(i))&&temp.charAt(i)!='.')
                                break;
                            n2=n2+temp.charAt(i);
                            last=i;
                        }
                        String ans=""+((Float.parseFloat(n1))+(Float.parseFloat(n2)));
                        temp=temp.substring(0,first)+ans+temp.substring(last+1,temp.length());
                    }
                }
                return temp;
            }
        });
    }
}