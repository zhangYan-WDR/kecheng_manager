<template>
  <div class="app-container home">
    <el-row :gutter="20">
      <el-col :sm="24" :lg="24">
        <blockquote class="text-warning" style="font-size: 14px">
          百度一下
          <br />
          <el-link
            href="www.baidu.com"
            type="primary"
            target="_blank"
            >www.baidu.com</el-link
          >
          <br />
          CSDN博客
          <br />
          <el-link
            href="https://www.csdn.net/"
            type="primary"
            target="_blank"
            >https://www.csdn.net/</el-link
          >
          <br />
          GitHub
          <br />
          <el-link
            href="https://github.com/"
            type="primary"
            target="_blank"
          >https://github.com/</el-link
          >
          <br />
        </blockquote>

        <hr />
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :sm="24" :lg="12" style="padding-left: 20px">
        <h2>课程后台管理系统</h2>
        <p>
          课程管理系统是适用于学校教师超级管理员为一体的后台管理系统。。。。。。。。。
        </p>
        <p>
          <b>当前版本:</b> <span>v{{ version }}</span>
        </p>
        <p>
          <el-tag type="danger">绝对可靠</el-tag>
        </p>
<!--        <p>-->
<!--          <el-button-->
<!--            type="primary"-->
<!--            size="mini"-->
<!--            icon="el-icon-cloudy"-->
<!--            plain-->
<!--            @click="goTarget('https://gitee.com/y_project/RuoYi-Vue')"-->
<!--            >访问码云</el-button-->
<!--          >-->
<!--          <el-button-->
<!--            size="mini"-->
<!--            icon="el-icon-s-home"-->
<!--            plain-->
<!--            @click="goTarget('http://ruoyi.vip')"-->
<!--            >访问主页</el-button-->
<!--          >-->
<!--        </p>-->
      </el-col>

      <el-col :sm="24" :lg="12" style="padding-left: 50px">
        <el-row>
          <el-col :span="12">
            <h2>技术选型</h2>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="6">
            <h4>后端技术</h4>
            <ul>
              <li>SpringBoot</li>
              <li>Spring Security</li>
              <li>JWT</li>
              <li>MyBatis</li>
              <li>Druid</li>
              <li>Fastjson</li>
              <li>...</li>
            </ul>
          </el-col>
          <el-col :span="6">
            <h4>前端技术</h4>
            <ul>
              <li>Vue</li>
              <li>Vuex</li>
              <li>Element-ui</li>
              <li>Axios</li>
              <li>Sass</li>
              <li>Quill</li>
              <li>...</li>
            </ul>
          </el-col>
        </el-row>
      </el-col>
    </el-row>
    <el-divider />
    <el-row :gutter="20">
      <el-col :xs="24" :sm="24" :md="12" :lg="8">
        <el-card class="update-log">
          <div slot="header" class="clearfix">
            <span>更新日志</span>
          </div>
          <el-collapse accordion>
            <el-collapse-item title="v1.1.0 - 2019-11-11">
              <ol>
                <li>新增在线用户管理</li>
                <li>新增按钮组功能实现（批量删除、导出、清空）</li>
                <li>新增查询条件重置按钮</li>
                <li>新增Swagger全局Token配置</li>
                <li>新增后端参数校验</li>
                <li>修复字典管理页面的日期查询异常</li>
                <li>修改时间函数命名防止冲突</li>
                <li>去除菜单上级校验，默认为顶级</li>
                <li>修复用户密码无法修改问题</li>
                <li>修复菜单类型为按钮时不显示权限标识</li>
                <li>其他细节优化</li>
              </ol>
            </el-collapse-item>
            <el-collapse-item title="v1.0.0 - 2019-10-08">
              <ol>
                <li>课程管理系统正式发布</li>
              </ol>
            </el-collapse-item>
          </el-collapse>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  name: "Index",
  data() {
    return {
      // 版本号
      version: "1.1.0"
    };
  },
  methods: {
    goTarget(href) {
      window.open(href, "_blank");
    }
  }
};
</script>

<style scoped lang="scss">
.home {
  blockquote {
    padding: 10px 20px;
    margin: 0 0 20px;
    font-size: 17.5px;
    border-left: 5px solid #eee;
  }
  hr {
    margin-top: 20px;
    margin-bottom: 20px;
    border: 0;
    border-top: 1px solid #eee;
  }
  .col-item {
    margin-bottom: 20px;
  }

  ul {
    padding: 0;
    margin: 0;
  }

  font-family: "open sans", "Helvetica Neue", Helvetica, Arial, sans-serif;
  font-size: 13px;
  color: #676a6c;
  overflow-x: hidden;

  ul {
    list-style-type: none;
  }

  h4 {
    margin-top: 0px;
  }

  h2 {
    margin-top: 10px;
    font-size: 26px;
    font-weight: 100;
  }

  p {
    margin-top: 10px;

    b {
      font-weight: 700;
    }
  }

  .update-log {
    ol {
      display: block;
      list-style-type: decimal;
      margin-block-start: 1em;
      margin-block-end: 1em;
      margin-inline-start: 0;
      margin-inline-end: 0;
      padding-inline-start: 40px;
    }
  }
}
</style>

