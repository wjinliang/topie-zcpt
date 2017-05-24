/**
 * Created by chenguojun on 8/10/16.
 */
;
(function ($, window, document, undefined) {
    var token = $.cookie('tc_t');
    if (token == undefined) {
        window.location.href = './login.html';
    }
    App.token=token;
    

    function getSubMenu(menus, menuId) {
        var subMenus = [];
        $.each(menus, function (i, m) {
            if (m.pId == menuId) {
                subMenus.push(m);
            }
        });
        return subMenus;
    }

    function getMenu(menus, menuId) {
        var subMenus = [];
        $.each(menus, function (i, m) {
            if (m.id == menuId) {
                subMenus.push(m);
            }
        });
        return subMenus;
    }

    function getTopMenu(menus) {
        var topMenus = [];
        $.each(menus, function (i, m) {
            if (m.pId == 0) {
                topMenus.push(m);
            } else {
                var subMenus = getMenu(menus, m.pId);
                if (subMenus.length == 0) {
                    topMenus.push(m);
                }
            }
        });
        return topMenus;
    }

    function recursionMenu(ele, menus, subMenus) {
        if (subMenus.length > 0) {
            ele += "<ul>";
            $.each(subMenus, function (i, m) {
                ele += ('<li data-url="' + m.url
                    + '" data-title="' + m.name
                    + '">'
                    + m.name
                    + '</li>');
                var sMenus = getSubMenu(menus, m.id);
                ele += '</li>';
            });
            ele += "</ul>";
        }
        return ele;
    }

    function initMenu(ul) {
        $.ajax(
            {
                type: 'GET',
                url: "../api/sys/function/current",
                contentType: "application/json",
                dataType: "json",
                beforeSend: function (request) {
                    request.setRequestHeader("X-Auth-Token", App.token);
                },
                success: function (result) {
                    if (result.code === 200) {
                        var menus = result.data;
//                        $.each(menus, function (i, m) {
//                            App.menusMapping[m.url] = m.name;
//                        });
                        var topMenus = getTopMenu(menus);
                        $.each(topMenus, function (i, m) {
                            var ele = '<h3>'+m.name+'</h3>';
                            var subMenus = getSubMenu(menus, m.id);
                            if (subMenus.length > 0) {
                                ele = recursionMenu(ele, menus, subMenus);
                            }else{
                            	ele = ele
                                + '<ul>'
                                + '<li data-url="' + m.url
                                + '" data-title="' + m.name
                                + '">'
                                + m.name
                                + '</li></ul>';

                            	
                            }
                            var li = $(ele);
//                            li.find("li[data-level=sub]").parents("li[data-level=top]").addClass("submenu").find("a:eq(0)").append('<span class="caret pull-right"></span>');
                            $(ul).append(li);
                    		
                        });
                        
                        $(".sideMenu li").click(function(){
                        	$(".sideMenu li.on").removeClass("on");
                        	$(this).addClass("on");
                        	$("#rightMain").attr("src",App.href+$(this).attr("data-url"));
                        });
                        
                        $('.sideMenu h3').click(function(){
                        	var $ul = $(this).next('ul');
                        	$('.sideMenu').find('ul').slideUp();
                        	$(".sideMenu h3.on").removeClass("on");
                        	if($ul.is(':visible')){
                        		$(this).next('ul').slideUp();
                        	}else{
                        		$(this).next('ul').slideDown();
                        		$(this).addClass("on");
                        	}
                        });
                        $('.sideMenu h3.on').next('ul').slideDown();
                    } else if (result.code === 401) {
                        alert("token失效,请登录!");
                        window.location.href = './login.html';
                    }
                },
                error: function (err) {
                }
            }
        );
    }

    

    $(document).ready(function () {
        initMenu(".sideMenu");
    });
})(jQuery, window, document);
