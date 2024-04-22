package crud;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@FacesConverter("dateTranslate")
public class DateTranslate implements Converter {

    private SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value == null || value.isEmpty())
            return null;
        try{
            return formatter.parse(value);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid date format, please try again with MM/dd/yyyy");
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value == null)
            return "";
        if(!(value instanceof Date)){
            throw new IllegalArgumentException("Invalid date format, please try again with MM/dd/yyyy");
        }
        return formatter.format((Date)value);
    }
}
