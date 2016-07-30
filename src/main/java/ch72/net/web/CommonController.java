package ch72.net.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by asato on 2016/07/30.
 * 共通機能に関するコントローラ。
 */
@Controller
public class CommonController {

    /**
     * メニュー画面へ遷移する。
     * @return メニュー画面のテンプレートのパス。
     */
    @RequestMapping(value = "menu")
    String menu() {
        return "common/menu";
    }
}
