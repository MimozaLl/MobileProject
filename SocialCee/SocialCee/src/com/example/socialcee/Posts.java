package com.example.socialcee;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Posts extends Activity {
	private DrawableManager imageDownload;

	//JSONObject for Notification(EventSubscription)
	public JSONObject json = new JSONObject();
	public String url = "https://api.socialcee.com/services/CommentHandler.ashx";
	public String postjson = new String();
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);
        imageDownload = new DrawableManager();
        
        LinearLayout content = new LinearLayout(this);
        content = (LinearLayout) findViewById(R.id.content); 
        String Message = "";
        int ncomments = 0;
        //ARRAY for storing all comments fetched from JSON
        String [] comments = new String[99];
        String [] images = new String[99];
        String [] names = new String[99];
        comments[0] = "Welcome to Maks Norway";
        images[0] = "http://graph.facebook.com/1126961968/picture&type=square";
        names[0] = "Nuhi Besimi";
        comments[1] = "It is a pleasure :D";
        images[1] = "http://graph.facebook.com/100000359694707/picture&type=square";
        names[1] = "Arlinda Rushiti";
        json = getNotification();
		try {
			Message = json.getString("Message");
			ncomments = json.getJSONArray("Comments").length();
			for(int i = 0; i < json.getJSONArray("Comments").length(); i++)
			{
				comments[i] = json.getJSONArray("Comments").getJSONArray(i).getString(1);
			}
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        LinearLayout ll = CreateBlock(1, Message, ncomments, comments, names, images);
        content.addView(ll);
 
    }
    public LinearLayout CreateBlock(int id, String PostMessage, int ncomments, String[] comments, String [] names, String [] images)
    {
    	LinearLayout ll = new LinearLayout(this);
    	ll.setOrientation(LinearLayout.VERTICAL);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT); 
        layoutParams.setMargins(30, 10, 0, 0);
    	//ll.setId(id);
    	ll.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));
    	layoutParams.setMargins(0, 20, 0, 0);
    	ll.setPadding(40, 50, 40, 0);
    	ll.setId(id+100);
    	ll.addView(AddHeaderBlock()); 
    	ll.addView(AddLine(), new ViewGroup.LayoutParams( ViewGroup.LayoutParams.FILL_PARENT, 2));
    	ll.addView(AddText(PostMessage, 20,0,0));
    	ll.addView(AddCommentBlock(id, ncomments, comments, names),layoutParams);
    	ll.addView(AddEditText(id));
    	ll.addView(AddButton(id));
    	
    	return ll;
    }
    public LinearLayout AddHeaderBlock()
    {
    	LinearLayout ll = new LinearLayout(this);
    	ll.setOrientation(LinearLayout.HORIZONTAL);
    	ll.addView(AddImage(R.drawable.internet_connection, 70, 70, 0));
    	ll.addView(AddImage(R.drawable.arrow, 60, 60, 50));
    	ll.addView(AddImage(R.drawable.internet_connection, 70, 70, 100));
    	
    	return ll;
    }
    public ImageView AddImage(int id, int width, int height, float x)
    {
    	ImageView iv = new ImageView(this);
    	iv.setImageDrawable(getResources().getDrawable(id));
    	iv.setLayoutParams(new LinearLayout.LayoutParams(width, height));
    	//iv.setX(x);
    	
    	return iv;
    }
    public View AddLine()
    {
    	View ruler = new View(this); 
        ruler.setBackgroundColor(Color.GRAY);
        //rl.addView(ruler, new ViewGroup.LayoutParams( ViewGroup.LayoutParams.FILL_PARENT, 2));
        
        return ruler;
    }
    public TextView AddText(String txt, int size, int left, int top)
    {
    	TextView t = new TextView(this);
    	t.setText(txt);
    	t.setTextSize(TypedValue.COMPLEX_UNIT_SP,size);
    	t.setPadding(left, top, 0, 0);
    	
    	return t;
    }
    public LinearLayout AddCommentBlock(int id, int nc, String [] commentsi, String [] names)
    {
    	int i;
    	LinearLayout comments = new LinearLayout(this);
    	comments.setBackgroundColor(Color.LTGRAY);
    	comments.setOrientation(LinearLayout.VERTICAL);
    	
    	comments.setId(id);
    	comments.setTag(id);
    	for(i=0; i<nc; i++)
    	{
    		comments.addView(AddComment(commentsi[i], names[i]));
    	}
    	
    	return comments;
    }
    public RelativeLayout AddComment(String commenti, String from)
    {
    	RelativeLayout comment = new RelativeLayout(this);
    	ImageView iv = new ImageView(this);
    	//iv.setImageBitmap(DownloadImage("http://graph.facebook.com/1126961968/picture&type=square"));
    	//iv.setLayoutParams(new LinearLayout.LayoutParams(70, 70));
    	//comment.addView(iv);
    	comment.addView(AddImage(R.drawable.internet_connection, 70, 70, 0));
    	comment.addView(AddText(from,15,80,0));
    	comment.addView(AddText(commenti,15,80,30));
    	
    	return comment;
    }
    public EditText AddEditText(int id)
    {
    	EditText et = new EditText(this);
    	et.setId(id+1000);
        et.setInputType(InputType.TYPE_CLASS_TEXT);
        
        return et;
    }
    public Button AddButton(int id)
    {
    	Button b = new Button(this);
        b.setText("Replay");
        b.setHeight(10);
        b.setWidth(130);
        b.setId(id);
        b.setOnClickListener(getOnClickDoSomething(b));
        
        return b;
    }
    public void EditComments(int id)
    {
    	EditText et = (EditText)findViewById(id+1000);
    	LinearLayout comments = new LinearLayout(this);
    	comments = (LinearLayout) findViewById(id);
    	String text;

    	text = et.getText().toString();
    	if (!text.isEmpty())
    	{
    		//COMMENT A POST   	        
    		postjson = BuildCommentJson(text).toString();
    		//String postJson = postjson.toString();
    		Request rp= new Request(postjson);
	        rp.execute(url);
    		comments.addView(AddComment(text, "Maks Norway"));
    		et.setText("");
    	}
    }
    View.OnClickListener getOnClickDoSomething(final Button b)  {
        return new View.OnClickListener() {
            public void onClick(View v) {
                EditComments(b.getId());
            }
        };
    }
    public JSONObject BuildCommentJson(String message)
    {
    	JSONObject object = new JSONObject();
        JSONObject from = new JSONObject(); {
            try {
            from.put("Id", "173526106122353");
            from.put("Name", "Maks Norway");
            from.put("Image", "http://facebook.com/profile.php?id=173526106122353");

            }catch (JSONException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
            }

            //Attcahment 
            JSONObject attach = new JSONObject();{
            try {
            attach.put("Type", 1);
            } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            }
            }	
            //New Post

            try {
            object.put("PostId", 180814);
            object.put("Message", message);
            object.put("From", from);
            object.put("TimeCreated", null);
            }catch (JSONException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
            }
        }
        return object;
    }
    public JSONObject getNotification()
    {
    	JSONObject data = new JSONObject();
    	JSONObject from = new JSONObject();
    	JSONObject from2 = new JSONObject();
    	JSONArray Comments = new JSONArray();
    	JSONObject comment = new JSONObject();
    	JSONObject comment2 = new JSONObject();
    	
    	try {
			from.put("Id", "1126961968");
			from.put("Name", "Nuhi Besimi");
			from.put("Image", "http://graph.facebook.com/1126961968/picture&type=square");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	try {
			from.put("Id", "100000359694707");
			from.put("Name", "Arlinda Rushiti");
			from.put("Image", "http://graph.facebook.com/100000359694707/picture&type=square");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	try {
			comment.put("PostId", 180814);
			comment.put("Message", "Welcome to Maks Norway");
			comment.put("From", from);
			comment.put("Id", 556157);
		} catch (JSONException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
    	try {
			comment2.put("PostId", 180814);
			comment2.put("Message", "It is a pleasure :D");
			comment2.put("From", from2);
			comment2.put("Id", 556164);
		} catch (JSONException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
    	
    	
    	try {
			Comments.put(0, comment);
			Comments.put(1, comment2);
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    	try {
    		data.put("From", from);
			data.put("Message", "Mobile System Programming - Project");
			data.put("Type", 1);
			data.put("Comments", Comments);
			data.put("Id", 180814);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	return data;
    }
    public Bitmap DownloadImage(String URL)
    {        
        Bitmap bitmap = null;
        InputStream in = null;        
        try {
            in = OpenHttpConnection(URL);
            bitmap = BitmapFactory.decodeStream(in);
            in.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return bitmap;                
    }
    private InputStream OpenHttpConnection(String urlString) 
    	    throws IOException
    	    {
    	        int response = -1;
    	        int http_status;
    	               
    	        URL url = new URL(urlString); 
    	        URLConnection conn = url.openConnection();
    	        
    	        InputStream in= null;
    	                 
    	        if (!(conn instanceof HttpURLConnection))                     
    	            throw new IOException("Not an HTTP connection");
    	        
    	   //     try{
    	            HttpURLConnection httpConn = (HttpURLConnection) conn;

    	             in = conn.getInputStream();  
    	                http_status = httpConn.getResponseCode();

    	                // better check it first
    	                if (http_status / 100 != 2) {
    	                  // redirects, server errors, lions and tigers and bears! Oh my!
    	                }
    	     //   }
    	    //    catch (Exception ex)
    	     //   {
    	       //     throw new IOException("Error connecting");            
    	       // }
    	        return in;     
    	    }
   
}
