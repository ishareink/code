```
import '@/plugin/bootstrap/css/bootstrap.min.css';
import ProCard from '@ant-design/pro-card' ;
import { Button, Select, Switch } from 'antd';
import { Input } from 'antd' ;
import { useState } from 'react';
import { Tag, Space } from 'antd';
import ProList from '@ant-design/pro-list';
import './css/faq.css';


const { TextArea } = Input;
const { Option } = Select;

const defaultData = [
  {
    id: '1',
    name: '语雀的天空',
    image:
      'https://gw.alipayobjects.com/zos/antfincdn/efFD%24IOql2/weixintupian_20170331104822.jpg',
    desc: '我是一条测试的描述',
  },
  {
    id: '2',
    name: 'Ant Design',
    image:
      'https://gw.alipayobjects.com/zos/antfincdn/efFD%24IOql2/weixintupian_20170331104822.jpg',
    desc: '我是一条测试的描述',
  },
  {
    id: '3',
    name: '蚂蚁金服体验科技',
    image:
      'https://gw.alipayobjects.com/zos/antfincdn/efFD%24IOql2/weixintupian_20170331104822.jpg',
    desc: '我是一条测试的描述',
  },
  {
    id: '4',
    name: 'TechUI',
    image:
      'https://gw.alipayobjects.com/zos/antfincdn/efFD%24IOql2/weixintupian_20170331104822.jpg',
    desc: '我是一条测试的描述',
  },
];

type DataItem = typeof defaultData[number];


export default function() {

  const [dataSource, setDataSource] = useState<DataItem[]>(defaultData);
  return (
    <>
      <ProCard  >
        <div className='container'>
          <h4 className='page-header'>提问</h4>
          <input type='hidden' id='user' />
          <div className='row top-buffer'>
            <div className='col-md-12'>
              <TextArea rows={4} />

            </div>

          </div>
          <br />
          <div className='row top-buffer'>
            <div className='col-md-3 col-lg-offset-6'>
              <div className='input-group'>
                <Input.Group compact>

                  <Input style={{ width: '30%' }} defaultValue='问题类型' disabled />
                  <Select
                    style={{ width: '50%' }}
                    value={'1'}
                  >
                    <Option value='1'>功能相关</Option>
                    <Option value='2'>界面相关</Option>
                  </Select>

                </Input.Group>


              </div>

            </div>
            <div className='col-md-3 pull-right'>
              是否匿名&nbsp;
              <Switch
                title={'匿名'} />&nbsp;&nbsp;
              <Button type='primary'>提问</Button>
            </div>

          </div>


          <h4 className='page-header'>问答</h4>

          <section className='cd-faq'>
            <ul className='cd-faq-categories'>
              <li><a className='selected' href='#basics'>功能相关</a></li>
              <li><a href='#ui'>界面相关</a></li>
            </ul>
            <div className='cd-faq-items'>
              <ul id='basics' className='cd-faq-group'>
                <ProList<DataItem>
                  rowKey='id'
                  dataSource={dataSource}
                  showActions='hover'
                  editable={{
                    onSave: async (key, record, originRow) => {
                      console.log(key, record, originRow);
                      return true;
                    },
                  }}
                  onDataSourceChange={setDataSource}
                  metas={{
                    title: {
                      dataIndex: 'name',
                    },
                    avatar: {
                      dataIndex: 'image',
                      editable: false,
                    },
                    description: {
                      dataIndex: 'desc',
                    },
                    subTitle: {
                      render: () => {
                        return (
                          <Space size={0}>
                            <Tag color='blue'>Ant Design</Tag>
                            <Tag color='#5BD8A6'>TechUI</Tag>
                          </Space>
                        );
                      },
                    },
                    actions: {
                      render: (text, row, index, action) => [
                        <a
                          onClick={() => {
                            action?.startEditable(row.id);
                          }}
                          key='link'
                        >
                          回复
                        </a>,
                      ],
                    },
                  }}
                />
              </ul>
            </div>
          </section>
        </div>


      </ProCard>
    </>
  );
}
```

```
<ProList<DataItem>
  rowKey='id'
  dataSource={this.state.dataSource}
  showActions='hover'
  editable={{
    onSave: async (key, record, originRow) => {
      console.log(key, record, originRow);
      return true;
    },
  }}

  metas={{
    title: {
      dataIndex: 'name',
    },
    avatar: {
      dataIndex: 'image',
      editable: false,
    },
    subTitle: {
      render: () => {
        return (
          <Space size={0}>
            <Tag color='blue'>功能相关</Tag>
          </Space>
        );
      },
    },
    actions: {
      render: (text, row, index, action) => [
        <a
          onClick={() => {
            action?.addEditRecord(row.id);
          }}
          key='link'
        >
          回复
        </a>,
      ],
    },
  }}
/>
```



yicheng日报

1、修改业务组表单

2、编写帮助中心下的用户反馈界面的布局

3、修改报错

4、明天计划对线下数据库增加数据，跑通业务组的板块