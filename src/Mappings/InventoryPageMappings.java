package Mappings;

import org.openqa.selenium.By;

public class InventoryPageMappings {
    public static By inventoryPageLogo = By.cssSelector("div.app_logo");
    public static By btnSort = By.cssSelector("[data-test='product-sort-container']");
    public static By btnLowToHigh = By.cssSelector(" span > select > option:nth-child(3)");
    public static By inventoryItems = By.cssSelector("div.inventory_item");
    public static By itemPrice = By.cssSelector("[data-test='inventory-item-price']");
    public static By lnkTwitter = By.cssSelector("[data-test='social-twitter']");
    public static By txtTwitter = By.cssSelector("header h1");
    public static By lnkFacebook = By.cssSelector("[data-test='social-facebook']");
    public static By txtFacebook = By.cssSelector("body > div.__fb-light-mode.x1n2onr6.x1vjfegm > div.x9f619.x1n2onr6.x1ja2u2z > div > div.x1uvtmcs.x4k7w5x.x1h91t0o.x1beo9mf.xaigb6o.x12ejxvf.x3igimt.xarpa2k.xedcshv.x1lytzrv.x1t2pt76.x7ja8zs.x1n2onr6.x1qrby5j.x1jfb8zj > div > div > div > div > div.x1exxf4d.x13fuv20.x178xt8z.x1l90r2v.x1pi30zi.x1swvt13 > div > div:nth-child(2) > div.x1i10hfl.xjbqb8w.x1ejq31n.xd10rxx.x1sy0etr.x17r0tee.x972fbf.xcfux6l.x1qhh985.xm0m39n.x1ypdohk.xe8uvvx.xdj266r.x11i5rnm.xat24cr.x1mh8g0r.xexx8yu.x4uap5.x18d9i69.xkhd6sd.x16tdsg8.x1hl2dhg.xggy1nq.x1o1ewxj.x3x9cwd.x1e5q0jg.x13rtm0m.x87ps6o.x1lku1pv.x1a2a7pz.x9f619.x3nfvp2.xdt5ytf.xl56j7k.x1n2onr6.xh8yej3 > div > div.x6s0dn4.x78zum5.xl56j7k.x1608yet.xljgi0e.x1e0frkt");
    public static By lnkLinkedin = By.cssSelector("[data-test='social-linkedin']");
    public static By txtLinkedin = By.cssSelector("#base-contextual-sign-in-modal > div > section > div > div > p.contextual-sign-in-modal__join-now.m-auto.font-sans.text-md.text-color-text.my-1");
    public static By btnAddCheapestItemToCart = By.cssSelector("[data-test='add-to-cart-sauce-labs-onesie']");
    public static By btnAddToCart = By.cssSelector("div.inventory_item_description button.btn_primary");
    public static By btnRemoveToCart = By.cssSelector("div.inventory_item_description button.btn_secondary");
    public static By txtItemName = By.cssSelector("[data-test='inventory-item-name']");
    public static By txtCartBadge = By.cssSelector("#shopping_cart_container > a > span");
    public static By btnCart = By.cssSelector("[data-test='shopping-cart-link']");

}
