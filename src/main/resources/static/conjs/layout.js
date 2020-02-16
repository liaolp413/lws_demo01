layui.use('layim', function(layim){
   var socket = layui.socket;
   var $ = layui.$;

   //判断系统是否支持WebSocket
    if ('WebSocket' in window){
        socket = new WebSocket('ws://' + window.location.host + '/websocket');
    }else {
        alert('Not support websocket')

    }
    //连接成功时触发
    socket.onopen = function(){
        console.log("WebSocket连接成功");
        socket.send('WebSocket连接成功');
    };

  //基础配置
  layim.config({
    init: {
    	url: '/user/init' //接口地址（返回的数据格式见下文）
        ,type: 'get' //默认get，一般可不填
        ,data: {} //额外参数
    } //获取主面板列表信息，下文会做进一步介绍
 
    //获取群员接口（返回的数据格式见下文）
    ,members: {
      url: '/biGroup/getMembers' //接口地址（返回的数据格式见下文）
      ,type: 'get' //默认get，一般可不填
      ,data: {} //额外参数
    }
     
 /*   //上传图片接口（返回的数据格式见下文），若不开启图片上传，剔除该项即可
    ,uploadImage: {
      url: '/message/uploadImage' //服务器接口地址
      ,type: 'post' //默认post
    } 
    
    //上传文件接口（返回的数据格式见下文），若不开启文件上传，剔除该项即可
    ,uploadFile: {
      url: '/message/uploadFile' //服务器接口地址
      ,type: 'post' //默认post
    }*/
    
    //扩展工具栏，下文会做进一步介绍（如果无需扩展，剔除该项即可）
    ,tool: [{
      alias: 'code' //工具别名
      ,title: '代码' //工具名称
      ,icon: '&#xe64e;' //工具图标，参考图标文档
    },{
      alias: 'talk' //工具别名
      ,title: '聊天' //工具名称
      ,icon: '&#xe63a;' //工具图标，参考图标文档
    },{
      alias: 'share' //工具别名
      ,title: '分享' //工具名称
      ,icon: '&#xe641;' //工具图标，参考图标文档
    }]
    
    
    //,title: 'WebIM' //自定义主面板最小化时的标题
    //,right: '300px' //主面板相对浏览器右侧距离
    //,minRight: '90px' //聊天面板最小化时相对浏览器右侧距离
    ,initSkin: '1.jpg' //1-5 设置初始背景
    ,skin: ['http://q2y023vul.bkt.clouddn.com/fm2.jpg'] //新增皮肤
    //,isfriend: false //是否开启好友
    //,isgroup: false //是否开启群组
    //,min: true //是否始终最小化主面板，默认false
    //,notice: true //是否开启桌面消息提醒，默认false
    //,voice: false //声音提醒，默认开启，声音文件为：default.mp3
    
    ,isAudio: true //开启聊天工具栏音频
    ,isVideo: true //开启聊天工具栏视频
    
    ,msgbox: '/static/lib/layim/html/list.html' //消息盒子页面地址，若不开启，剔除该项即可
  //  ,find: layui.cache.dir + 'lws_demo01//static/lib/layim/html/add.html'//发现页面地址，若不开启，剔除该项即可
    ,chatLog: '/static/lib/layim/html/chatlog.html'//聊天记录页面地址，若不开启，剔除该项即可
  });
  


});      