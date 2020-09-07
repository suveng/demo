import { UserOutlined } from '@ant-design/icons';

const IndexSiderRouterConfig = [
    {
        title: '用户',
        icon: UserOutlined,
        key: '/index/console',
        child: [
            {key: '/index/user/settings', title: '设置',},
            {key: '/index/user/space', title: '空间',},
            {key: '/index/user/message', title: '消息',},
            {key: '/login', title: '注销',},
            {key: '/login', title: '退出',},
        ]
    },
    {
        title: '系统介绍',
        key: '/index/introduce',
    },
]

export default IndexSiderRouterConfig;
