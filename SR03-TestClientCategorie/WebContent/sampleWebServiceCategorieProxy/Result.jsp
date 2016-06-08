<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleWebServiceCategorieProxyid" scope="session" class="WebService.WebServiceCategorieProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleWebServiceCategorieProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleWebServiceCategorieProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleWebServiceCategorieProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        WebService.WebServiceCategorie getWebServiceCategorie10mtemp = sampleWebServiceCategorieProxyid.getWebServiceCategorie();
if(getWebServiceCategorie10mtemp == null){
%>
<%=getWebServiceCategorie10mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
</TABLE>
<%
}
break;
case 15:
        gotMethod = true;
        beans.Categorie[] getCategories15mtemp = sampleWebServiceCategorieProxyid.getCategories();
if(getCategories15mtemp == null){
%>
<%=getCategories15mtemp %>
<%
}else{
        String tempreturnp16 = null;
        if(getCategories15mtemp != null){
        java.util.List listreturnp16= java.util.Arrays.asList(getCategories15mtemp);
        tempreturnp16 = listreturnp16.toString();
        }
        %>
        <%=tempreturnp16%>
        <%
}
break;
case 18:
        gotMethod = true;
        String categorie_id_1id=  request.getParameter("categorie_id25");
        int categorie_id_1idTemp  = Integer.parseInt(categorie_id_1id);
        beans.Categorie getCategorie18mtemp = sampleWebServiceCategorieProxyid.getCategorie(categorie_id_1idTemp);
if(getCategorie18mtemp == null){
%>
<%=getCategorie18mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nom:</TD>
<TD>
<%
if(getCategorie18mtemp != null){
java.lang.String typenom21 = getCategorie18mtemp.getNom();
        String tempResultnom21 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenom21));
        %>
        <%= tempResultnom21 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">id:</TD>
<TD>
<%
if(getCategorie18mtemp != null){
%>
<%=getCategorie18mtemp.getId()
%><%}%>
</TD>
</TABLE>
<%
}
break;
case 27:
        gotMethod = true;
        String categorie_id_2id=  request.getParameter("categorie_id30");
        int categorie_id_2idTemp  = Integer.parseInt(categorie_id_2id);
        boolean delCategorie27mtemp = sampleWebServiceCategorieProxyid.delCategorie(categorie_id_2idTemp);
        String tempResultreturnp28 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(delCategorie27mtemp));
        %>
        <%= tempResultreturnp28 %>
        <%
break;
case 32:
        gotMethod = true;
        String nom_3id=  request.getParameter("nom39");
            java.lang.String nom_3idTemp = null;
        if(!nom_3id.equals("")){
         nom_3idTemp  = nom_3id;
        }
        beans.Categorie newCategorie32mtemp = sampleWebServiceCategorieProxyid.newCategorie(nom_3idTemp);
if(newCategorie32mtemp == null){
%>
<%=newCategorie32mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nom:</TD>
<TD>
<%
if(newCategorie32mtemp != null){
java.lang.String typenom35 = newCategorie32mtemp.getNom();
        String tempResultnom35 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenom35));
        %>
        <%= tempResultnom35 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">id:</TD>
<TD>
<%
if(newCategorie32mtemp != null){
%>
<%=newCategorie32mtemp.getId()
%><%}%>
</TD>
</TABLE>
<%
}
break;
case 41:
        gotMethod = true;
        String id_4id=  request.getParameter("id44");
        int id_4idTemp  = Integer.parseInt(id_4id);
        String nom_5id=  request.getParameter("nom46");
            java.lang.String nom_5idTemp = null;
        if(!nom_5id.equals("")){
         nom_5idTemp  = nom_5id;
        }
        boolean modifyCategorie41mtemp = sampleWebServiceCategorieProxyid.modifyCategorie(id_4idTemp,nom_5idTemp);
        String tempResultreturnp42 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(modifyCategorie41mtemp));
        %>
        <%= tempResultreturnp42 %>
        <%
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>