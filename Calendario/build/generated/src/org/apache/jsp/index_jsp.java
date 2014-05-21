package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <link href='css/fullcalendar.css' rel='stylesheet' />\n");
      out.write("        <link href='css/fullcalendar.print.css' rel='stylesheet' media='print' />\n");
      out.write("\n");
      out.write("        <style>\n");
      out.write("\n");
      out.write("            body {\n");
      out.write("                margin-top: 40px;\n");
      out.write("                text-align: center;\n");
      out.write("                font-size: 14px;\n");
      out.write("                font-family: \"Lucida Grande\",Helvetica,Arial,Verdana,sans-serif;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("            #calendar {\n");
      out.write("                width: 900px;\n");
      out.write("                margin: 0 auto;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id='calendar'></div>\n");
      out.write("    </body>\n");
      out.write("    <script src='js/jquery.min.js'></script>\n");
      out.write("    <script src='js/jquery-ui.custom.min.js'></script>\n");
      out.write("    <script src='js/fullcalendar.min.js'></script>\n");
      out.write("    <script>\n");
      out.write("\n");
      out.write("        $(document).ready(function() {\n");
      out.write("            var date = new Date();\n");
      out.write("            var d = date.getDate();\n");
      out.write("            var m = date.getMonth();\n");
      out.write("            var y = date.getFullYear();\n");
      out.write("\n");
      out.write("            var calendar = $('#calendar').fullCalendar({\n");
      out.write("                editable: true,\n");
      out.write("                header: {\n");
      out.write("                    left: 'prev,next today',\n");
      out.write("                    center: 'title',\n");
      out.write("                    right: 'month,agendaWeek,agendaDay'\n");
      out.write("                },\n");
      out.write("                events: \"Events?ban=1\",\n");
      out.write("                // Convert the allDay from string to boolean\n");
      out.write("                eventRender: function(event, element, view) {\n");
      out.write("                    if (event.allDay === 'true') {\n");
      out.write("                        event.allDay = true;\n");
      out.write("                    } else {\n");
      out.write("                        event.allDay = false;\n");
      out.write("                    }\n");
      out.write("                },\n");
      out.write("                selectable: true,\n");
      out.write("                selectHelper: true,\n");
      out.write("                select: function(start, end, allDay) {\n");
      out.write("                    var title = prompt('Event Title:');\n");
      out.write("                    var url = prompt('Type Event url, if exits:');\n");
      out.write("                    if (title) {\n");
      out.write("                        var start = $.fullCalendar.formatDate(start, \"yyyy-MM-dd HH:mm:ss\");\n");
      out.write("                        var end = $.fullCalendar.formatDate(end, \"yyyy-MM-dd HH:mm:ss\");\n");
      out.write("                        $.ajax({\n");
      out.write("                            url: 'Events?ban=3',\n");
      out.write("                            data: 'title=' + title + '&start=' + start + '&end=' + end + '&url=' + url,\n");
      out.write("                            type: \"POST\",\n");
      out.write("                            success: function(json) {\n");
      out.write("                                alert('Added Successfully');\n");
      out.write("                            }\n");
      out.write("                        });\n");
      out.write("                        calendar.fullCalendar('renderEvent',\n");
      out.write("                                {\n");
      out.write("                                    title: title,\n");
      out.write("                                    start: start,\n");
      out.write("                                    end: end,\n");
      out.write("                                    allDay: allDay\n");
      out.write("                                },\n");
      out.write("                        true // make the event \"stick\"\n");
      out.write("                                );\n");
      out.write("                    }\n");
      out.write("                    calendar.fullCalendar('unselect');\n");
      out.write("                },\n");
      out.write("                editable: true,\n");
      out.write("                        eventDrop: function(event, delta) {\n");
      out.write("                            var start = $.fullCalendar.formatDate(event.start, \"yyyy-MM-dd HH:mm:ss\");\n");
      out.write("                            var end = $.fullCalendar.formatDate(event.end, \"yyyy-MM-dd HH:mm:ss\");\n");
      out.write("                            $.ajax({\n");
      out.write("                                url: 'Events?ban=2',\n");
      out.write("                                data: 'title=' + event.title + '&start=' + start + '&end=' + end + '&id=' + event.id,\n");
      out.write("                                type: \"POST\",\n");
      out.write("                                success: function(json) {\n");
      out.write("                                    alert(\"Updated Successfully\");\n");
      out.write("                                }\n");
      out.write("                            });\n");
      out.write("                        },\n");
      out.write("                eventResize: function(event) {\n");
      out.write("                    var start = $.fullCalendar.formatDate(event.start, \"yyyy-MM-dd HH:mm:ss\");\n");
      out.write("                    var end = $.fullCalendar.formatDate(event.end, \"yyyy-MM-dd HH:mm:ss\");\n");
      out.write("                    $.ajax({\n");
      out.write("                        url: 'Events?ban=2',\n");
      out.write("                        data: 'title=' + event.title + '&start=' + start + '&end=' + end + '&id=' + event.id,\n");
      out.write("                        type: \"POST\",\n");
      out.write("                        success: function(json) {\n");
      out.write("                            alert(\"Updated Successfully\");\n");
      out.write("                        }\n");
      out.write("                    });\n");
      out.write("\n");
      out.write("                }\n");
      out.write("\n");
      out.write("            });\n");
      out.write("\n");
      out.write("            eventClick: function(event) {\n");
      out.write("                var decision = confirm(\"Do you really want to do that?\");\n");
      out.write("                if (decision) {\n");
      out.write("                    $.ajax({\n");
      out.write("                        type: \"POST\",\n");
      out.write("                        url: \"your url/delete_events.php\",\n");
      out.write("                        data: \"&id=\" + event.id\n");
      out.write("                    });\n");
      out.write("                    $('#calendar2').fullCalendar('removeEvents', event.id);\n");
      out.write("\n");
      out.write("                } else {\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        });\n");
      out.write("\n");
      out.write("    </script>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
