package reflect.editor;

import java.util.Date;

/**
 * Created by chen.mh on 2017/4/13.
 */
public class NodeDO {
    private String name;

    private String email;

    private Date dateTime;

    public String toString(){
        return name + "\t" + email + "\t" + getDateTimeString();
    }

    public String getDateTimeString(){
        return NodeDoEditor.DEFAULT_DATE_FORMAT.format(dateTime);
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }
}
