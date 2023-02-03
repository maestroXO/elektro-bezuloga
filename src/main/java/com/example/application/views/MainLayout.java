package com.example.application.views;


import com.example.application.components.appnav.AppNav;
import com.example.application.components.appnav.AppNavItem;
import com.example.application.views.arhiva_prometa.Arhiva_prometaView;
import com.example.application.views.fizička_lokacija.Fizička_lokacijaView;
import com.example.application.views.jm.JMView;
import com.example.application.views.korisnik_aplikacije.Korisnik_aplikacijeView;
import com.example.application.views.oprema.OpremaView;
import com.example.application.views.početna.PočetnaView;
import com.example.application.views.privilegije.PrivilegijeView;
import com.example.application.views.radnici.RadniciView;
import com.example.application.views.sistematizacija.SistematizacijaView;
import com.example.application.views.terenska_jedinica.Terenska_jedinicaView;
import com.example.application.views.transakcije.TransakcijeView;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.theme.lumo.LumoUtility;

/**
 * The main view is a top-level placeholder for other views.
 */
public class MainLayout extends AppLayout {

    private H2 viewTitle;

    public MainLayout() {
        setPrimarySection(Section.DRAWER);
        addDrawerContent();
        addHeaderContent();
    }

    private void addHeaderContent() {
        DrawerToggle toggle = new DrawerToggle();
        toggle.getElement().setAttribute("aria-label", "Menu toggle");

        viewTitle = new H2();
        viewTitle.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);

        addToNavbar(true, toggle, viewTitle);
    }

    private void addDrawerContent() {
        H1 appName = new H1("Elektro");
        appName.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);
        Header header = new Header(appName);

        Scroller scroller = new Scroller(createNavigation());

        addToDrawer(header, scroller, createFooter());
    }

    private AppNav createNavigation() {
        // AppNav is not yet an official component.
        // For documentation, visit https://github.com/vaadin/vcf-nav#readme
        AppNav nav = new AppNav();

        nav.addItem(new AppNavItem("Početna", PočetnaView.class, "la la-file"));
        nav.addItem(new AppNavItem("Sistematizacija", SistematizacijaView.class, "la la-columns"));
        nav.addItem(new AppNavItem("Terenska_jedinica", Terenska_jedinicaView.class, "la la-columns"));
        nav.addItem(new AppNavItem("Transakcije", TransakcijeView.class, "la la-columns"));
        nav.addItem(new AppNavItem("Fizička_lokacija", Fizička_lokacijaView.class, "la la-columns"));
        nav.addItem(new AppNavItem("Radnici", RadniciView.class, "la la-columns"));
        nav.addItem(new AppNavItem("Privilegije", PrivilegijeView.class, "la la-columns"));
        nav.addItem(new AppNavItem("JM", JMView.class, "la la-columns"));
        nav.addItem(new AppNavItem("Oprema", OpremaView.class, "la la-columns"));
        nav.addItem(new AppNavItem("Korisnik_aplikacije", Korisnik_aplikacijeView.class, "la la-columns"));
        nav.addItem(new AppNavItem("Arhiva_prometa", Arhiva_prometaView.class, "la la-columns"));

        return nav;
    }

    private Footer createFooter() {
        Footer layout = new Footer();

        return layout;
    }

    @Override
    protected void afterNavigation() {
        super.afterNavigation();
        viewTitle.setText(getCurrentPageTitle());
    }

    private String getCurrentPageTitle() {
        PageTitle title = getContent().getClass().getAnnotation(PageTitle.class);
        return title == null ? "" : title.value();
    }
}
