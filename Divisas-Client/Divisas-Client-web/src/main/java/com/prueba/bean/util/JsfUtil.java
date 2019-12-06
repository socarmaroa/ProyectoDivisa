package com.prueba.bean.util;

import com.prueba.modelo.TbDivisa;
import com.prueba.modelo.TbTasacambio;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.model.SelectItem;

public class JsfUtil {

    public static SelectItem[] getSelectItems(List<?> entities, boolean selectOne) {
        int size = selectOne ? entities.size() + 1 : entities.size();
        SelectItem[] items = new SelectItem[size];
        int i = 0;
        if (selectOne) {
            items[0] = new SelectItem("", "---");
            i++;
        }
        for (Object x : entities) {
            if(x instanceof TbDivisa){
                items[i++] = new SelectItem(x,((TbDivisa) x).getAbreviaturaDivisa()+"-"+((TbDivisa) x).getNombreDivisa());
            }else if(x instanceof TbTasacambio){
                TbTasacambio TbTasacambio=((TbTasacambio) x);
                String TbDivisa1=TbTasacambio.getIdDivisa1().getNombreDivisa()+"-"+TbTasacambio.getIdDivisa1().getAbreviaturaDivisa();
                String TbDivisa2=TbTasacambio.getIdDivisa2().getNombreDivisa()+"-"+TbTasacambio.getIdDivisa2().getAbreviaturaDivisa();
                String toString=TbDivisa1+"/"+TbDivisa2;
                items[i++] = new SelectItem(x,toString);
            }else{
            items[i++] = new SelectItem(x, x.toString());
            }
        }
        return items;
    }

    public static void addErrorMessage(Exception ex, String defaultMsg) {
        String msg = ex.getLocalizedMessage();
        if (msg != null && msg.length() > 0) {
            addErrorMessage(msg);
        } else {
            addErrorMessage(defaultMsg);
        }
    }

    public static void addErrorMessages(List<String> messages) {
        for (String message : messages) {
            addErrorMessage(message);
        }
    }

    public static void addErrorMessage(String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }

    public static void addSuccessMessage(String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);
        FacesContext.getCurrentInstance().addMessage("successInfo", facesMsg);
    }

    public static String getRequestParameter(String key) {
        return FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(key);
    }

    public static Object getObjectFromRequestParameter(String requestParameterName, Converter converter, UIComponent component) {
        String theId = JsfUtil.getRequestParameter(requestParameterName);
        return converter.getAsObject(FacesContext.getCurrentInstance(), component, theId);
    }

}
