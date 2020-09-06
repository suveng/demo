import { UserOutlined } from '@ant-design/icons';

const RouterConfig = [
    {
      title: '控制台',
      icon: UserOutlined,
      key: '/index'
    },
    {
      title: '用户管理',
      icon: UserOutlined,
      key: '/index/user',
      child: [
        {key: '/index/user/list', title: '用户列表',},
        {
          key: '/index/user/add',
          title: '添加用户',
        }
      ]
    },
    {
      title: '部门管理',
      icon: UserOutlined,
      key: '/index/department',
      child: [
        {key: '/index/department/list', title: '部门列表', },
        {key: '/index/department/add', title: '添加部门', },
      ]
    },
    {
      title: '职位管理',
      icon: UserOutlined,
      key: '/home/entry',
      child: [
        {key: '/home/entry/form/basic-form', title: '职位列表', },
        {key: '/home/entry/form/step-form', title: '添加职位', }
      ]
    },
    {
      title: '请假',
      key: '/home/about'
    },
    {
      title: '加班',
      key: '/home/abouta'
    }
  ]

  export default RouterConfig;
