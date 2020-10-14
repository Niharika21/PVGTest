//package org.vaadin.paul.spring.ui.views;
//
//import com.vaadin.flow.component.Tag;
//import com.vaadin.flow.component.button.Button;
//import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
//import com.vaadin.flow.dom.Element;
//import com.vaadin.flow.dom.ElementFactory;
//import com.vaadin.flow.router.PageTitle;
//import com.vaadin.flow.router.Route;
//
//
//@Tag("sa-Welcome-view")
//@Route(value = WelcomeView.ROUTE)
//@PageTitle("Welcome")
//public class WelcomeView extends HorizontalLayout {
//	public static final String ROUTE = "welcome";
//		public WelcomeView() {
//			
//			Button click = new Button();
//			click.setText("welcome");
//			add(click);
//			
//			// simple link to the logout endpoint provided by Spring Security
//	        Element logoutLink = ElementFactory.createAnchor("logout", "Logout");
//	        getElement().appendChild(logoutLink);
//		}
//
//}

package org.vaadin.paul.spring.ui.views;

//import com.example.chat.views.chat.ChatView; // import chat view class
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.server.VaadinSession;


@Tag("sa-Welcome-view")
@Route(value = JoinView.ROUTE)
@PageTitle("join")
//@Route("join")
@CssImport("/styles/views/join/join-view.css")
//@RouteAlias(value = "")

public class JoinView extends VerticalLayout {
	public static final String ROUTE = "join";

    public JoinView() {
        addClassName(getClass().getSimpleName());

        H1 title = new H1("ComAssist");
        title.addClassName(getClass().getSimpleName() + "-title");

        TextField nickname = new TextField();
        nickname.addClassName(getClass().getSimpleName() + "-nickname");
        nickname.setPlaceholder("Enter your username...");

        Button enter = new Button("Enter", event -> enter(nickname.getValue()));
        enter.addClassName(getClass().getSimpleName() + "-enter");
        enter.addClickShortcut(Key.ENTER);

        VerticalLayout form = new VerticalLayout(title, nickname, enter);
        form.setSizeUndefined();
        form.addClassName(getClass().getSimpleName() + "-form");
        add(form);
    }

    private void enter(String nickname) {
        if (nickname.trim().isEmpty()) {
            Notification.show("Enter a nickname");
        } else {
            VaadinSession.getCurrent().setAttribute("nickname", nickname);
            UI.getCurrent().navigate(ChatView.class, "Alice");
        }
    }

}
