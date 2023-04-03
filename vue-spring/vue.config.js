const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  devServer: {
    proxy: {
      '/api': { 
        target: `http://${process.env.backend}`,
        changeOrigin: true,
      }, 
    },
  },

  lintOnSave: false,
})