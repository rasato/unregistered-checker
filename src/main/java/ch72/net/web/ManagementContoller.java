package ch72.net.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by asato on 2016/07/30.
 * フィルタを管理する機能のWebアプリコントローラ。
 */
@Controller
@RequestMapping("manage")
public class ManagementContoller {

    /**
     * 登録されているフィルタ一覧の表示画面へ遷移する。
     * @return 登録フィルタ一覧画面のテンプレートのパス。
     */
    @RequestMapping(method = RequestMethod.GET)
    String list() {
        return "manage/list";
    }
}
