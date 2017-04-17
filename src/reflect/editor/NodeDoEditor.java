package reflect.editor;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by chen.mh on 2017/4/13.
 */
public class NodeDoEditor extends PropertyEditorSupport {

    public final static SimpleDateFormat DEFAULT_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public void setAsText(String text) throws IllegalArgumentException {

        String[] tokens = text.split("\\|");
        NodeDO nodeDO = new NodeDO();
        nodeDO.setName(tokens[0]);
        nodeDO.setEmail(tokens[1]);
        try {
            nodeDO.setDateTime(DEFAULT_DATE_FORMAT.parse(tokens[2]));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        setValue(nodeDO);
    }
}
