module.exports = {
    entry: './typescript_ex.ts',
    output: {
        filename:'./dist/bundle.js'
    },
    module: {
        rules:[
            {
                test:/\.ts$/,
                loader:'ts-loader'
            }
        ]

    }
};