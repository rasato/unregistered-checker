package ch72.net.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by asato on 2016/07/28.
 * 登録されているフィルタを使用する機能のWebアプリコントローラ。
 */
@Controller
@RequestMapping("service")
public class ServiceController {

    /**
     * フィルタ機能の入力画面に遷移する。
     * @return 入力画面のテンプレートのパス。
     */
    @RequestMapping(method = RequestMethod.GET)
    String input() {
        return "service/input";
    }

    /**
     * フィルタの適用結果表示画面に遷移する。
     * @return フィルタの適用結果を表示する画面のテンプレートのパス。
     */
    @RequestMapping(value = "apply", method = RequestMethod.POST)
    String apply() {
        return "service/result";
    }
}
