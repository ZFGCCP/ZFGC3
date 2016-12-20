exports.config = {
  seleniumAddress: 'http://localhost:4444/wd/hub',
  specs: ['src/test/e2e/_login.js','src/test/e2e/**/*.js'],
  baseUrl: 'http://localhost:8080/',
  params: {
	  username: 'admin',
	  password: 'admin'
  }