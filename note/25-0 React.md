# 25-0 前端-React技术栈

- react
- babel
- react-route
- redux
- redux-saga
- hook
- antd

官方文档

[React 官方中文文档 – 用于构建用户界面的 JavaScript 库](https://zh-hans.reactjs.org/)



## React是什么? 

官网api



### 架构是什么? 

### 特性是什么? 

### 应用场景是什么? 

### 优缺点是什么? 



## 为什么会出现React? 





## 如何使用React? 



### 创建React项目

```shell
npx create-react-app my-app
cd my-app
npm start
```

### React组件编写

1. 继承 `React.Component`
2. 必须要有构造函数, 必须使用 `super()` 构造
3. 必须要有 `render()` 函数

```jsx
class App extends React.Component{
  construct(props){
    super(props);
    this.state={};
  }

  render(){
    return ();
  }
}
```

### react-dom 和 react-router-dom

`react-dom` 提供了`router`的相关`api`,包括`Router`,`Route`,`Switch`等,但是没有提供`dom`相关操作的`api`

`react-router-dom` 可以通过`dom`控制路由

可以在`package.json`的文件中查看到相关的依赖

1. 安装 `react-router-dom`

```shell
npm install --save-dev react-router-dom
```

2. 代码中引入 `react-router-dom`



### sass-node 样式


Sass是一种预处理器脚本语言，可以解释或编译成层叠样式表（CSS）。
Sass包含两种语法：较旧的语法使用缩进将代码块和换行符分隔为单独的规则；较新的语法SCSS使用像CSS这样的块格式。它使用大括号来表示代码块和分号来分隔块中的行。
缩进语法和SCSS文件传统上分别给出扩展名.sass和.scss

[node-sass是什么？ - html中文网](https://m.html.cn/qa/node-js/10763.html)



2020/8/21 
怎么配置sass-node? 

注意: 
版本: 
node 12.15.0
npm 6.13.4
"react": "^16.13.1",
"react-dom": "^16.13.1",
"react-scripts": "3.4.3"
"node-sass": "^4.14.1",
"react-router-dom": "^5.2.0",
"sass-loader": "^9.0.3"

不用配置下面的webpack配置,即可使用scss

1. 安装
安装 `sass-loader` 和 `node-sass` 组件

```shell
npm install --save-dev sass-loader node-sass
```

2. 打开react的webpack配置

位置: `node_modules/react-scripts/config/webpack.config.dev.js`

找到module下的rules，然后找到最后一个配置，修改成如下的样子

```js
{

    exclude: [/\.js$/,/\.html$/,/\.json$/,/\.scss$/],

    loader: require.resolve('file-loader'),

    options: {

            name: 'static/media/[name].[hash:8].[ext]',

        },

},

{

    test:/\.scss$/,

    loaders:['style-loader','css-loader','sass-loader']

}
```
[React的Sass配置 - 简书](https://www.jianshu.com/p/d3fbd9774931)

### sass全局变量使用

普通变量引用步骤
1. 在 `scss` 文件中引入配置文件
2. 使用已经引入的配置文件的变量

```sass
@import "文件路径"

$变量
```

什么是全局sass变量? 

目的: 项目中的所有sass文件均可使用变量和方法,无需单独引入

如何做到? 

1. 安装依赖


```shell
cnpm install --save-dev sass-resources-loader
```

如果没有config文件,可以

```shell
npm run eject
```

https://blog.csdn.net/qq_34648151/article/details/105964879

2. 修改配置文件

找到一下代码
```

{
    test: sassRegex,
    exclude: sassModuleRegex,
    use: getStyleLoaders(
      {
        importLoaders: 3,
        sourceMap: isEnvProduction && shouldUseSourceMap,
      },
      'sass-loader'
    ),
    sideEffects: true,
}

```

在getStyleLoaders下添加

```

.concat({
     loader: 'sass-resources-loader',
     options: {
         resources: [
             // 这里按照你的文件路径填写
             path.resolve(__dirname, './../src/common.scss')
         ]
     }
 })
```


### 配置 ant-design 组件

1. 安装组件


```shell
cnpm install --save antd 
```

依赖按需加载

```shell
cnpm install babel-plugin-import --save-dev
```
2. 配置按需加载

找到下面位置

```shell

{
  test: /\.(js|mjs|jsx|ts|tsx)$/,
  include: paths.appSrc,
  loader: require.resolve('babel-loader'),
  options: {
    customize: require.resolve(
      'babel-preset-react-app/webpack-overrides'
    ),

    plugins: [
      [
        require.resolve('babel-plugin-named-asset-import'),
        {
          loaderMap: {
            svg: {
              ReactComponent:
                '@svgr/webpack?-svgo,+titleProp,+ref![path]',
            },
          },
        },
      ],
    ],
```

在plugin加入下面配置
```shell
["import",{libararyName:"antd",style:"css"}]
```

https://ant.design/docs/react/use-with-create-react-app-cn



### npm --save-dev --save 的区别?

[npm --save-dev --save 的区别 - 个人文章 - SegmentFault 思否](https://segmentfault.com/a/1190000010686415)


### React Fragment 标签

作用: 去掉render的根标签, 可以不用是div, 作为一个div的替代品

[React16免费基础视频教程_哔哩哔哩 (゜-゜)つロ 干杯~-bilibili](https://www.bilibili.com/video/BV1g4411i7po)
[ReactRouter免费视频教程精讲版_哔哩哔哩 (゜-゜)つロ 干杯~-bilibili](https://www.bilibili.com/video/BV1Z4411f7T5)
[黑马程序员 \| redux全局状态管理学习路线之一 : redux&react-redux_哔哩哔哩 (゜-゜)つロ 干杯~-bilibili](https://www.bilibili.com/video/BV1oE411V7RW?from=search&seid=2125214182511152180)

### 页面跳转

[react-router官网教程](https://reactrouter.com/web/guides/quick-start)

- react-router
- react-router-dom

- withRouter



#### 路由模式

5种路由模式

1. HashRouter (带#号)
2. BrowserRouter 不带#号 上线后需要网关指向
3. CreateMemoryHistory 
4. Switch 相同地址 只匹配一个
5. exact 关键字,精准匹配

[简介 \| React Router 中文文档](https://react-guide.github.io/react-router-cn/docs/Introduction.html)

`react-router-dom`包

- HashRouter
- Route
- Router
- Switch
- Link



### 数据存储



#### 存储方式

- 内存对象
- cookie
- session storage
- local storage
- redux



##### 内存对象

存储在react的对象中

优点: 

- 简单方便

缺点:

- 全局失效

##### cookie

1. cookie是存储在浏览器上的一小段数据，用来记录某些当页面关闭或者刷新后仍然需要记录的信息。在控制台用 「document.cookie」查看你当前正在浏览的网站的cookie。
2. cookie可以使用 js 在浏览器直接设置（用于记录不敏感信息，如用户名）, 也可以在服务端通使用 HTTP 协议规定的 set-cookie 来让浏览器种下cookie，这是最常见的做法。（打开一个网站，清除全部cookie，然后刷新页面，在network的Response headers试试找一找set-cookie吧）
3. 每次网络请求 Request headers 中都会带上cookie。所以如果 cookie 太多太大对传输效率会有影响。
4. 一般浏览器存储cookie 最大容量为4k，所以大量数据不要存到cookie。
5. 设置cookie时的参数：

- - path：表示 cookie 影响到的路径，匹配该路径才发送这个 cookie。expires 和 maxAge：告诉浏览器 cookie 时候过期，maxAge 是 cookie 多久后过期的相对时间。不设置这两个选项时会产生 session cookie，session cookie 是 transient 的，当用户关闭浏览器时，就被清除。一般用来保存 session 的 session_id。
  - secure：当 secure 值为 true 时，cookie 在 HTTP 中是无效，在 HTTPS 中才有效
  - httpOnly：浏览器不允许脚本操作 document.cookie 去更改 cookie。一般情况下都应该设置这个为 true，这样可以避免被 xss 攻击拿到 cookie。[[cookie 参数\]](https://link.zhihu.com/?target=https%3A//github.com/alsotang/node-lessons/tree/master/lesson16)[[简述 Cookie 是什么\]](https://zhuanlan.zhihu.com/p/22396872?refer=study-fe)

优点: 

- 全局使用
- 时效性极高的扩展性和可用性

缺点: 

- 容量小, 4k

- 每个特定的域名下最多生成20个cookie
- 安全问题, 截取cookie伪造相同请求
- 状态不能保存在客户端



##### session storage 

用来存储客户端临时信息的对象



优点:

- 相比cookie,容量大, 5m

缺点:

- 只能存储字符串类型的对象
- 遵守同源策略

- sessionStorage有期限，当窗口或浏览器关闭时就会被销毁



##### local storage 

本地存储

优点: 

- 同源的不同窗口下可共享，在不同浏览器中不可共享
- 时间不限, 除非被清除了
- 容量大 , 5m

缺点: 

- 有风险被清除, 最好不存重要数据到客户端