var gulp = require('gulp');
var sass = require('gulp-ruby-sass');
var gutil = require('gulp-util');
var sourcemaps = require('gulp-sourcemaps');
var uglify = require('gulp-uglify');
var del = require('del');

var runningEnv = (gutil.env.type || 'dev').toLowerCase();
var isDevEnv = !gutil.env.type || gutil.env.type.toLowerCase() === 'dev';
var isProdEnv = gutil.env.type && gutil.env.type.toLowerCase() === 'prod';

var outputDir = isDevEnv ? '.' : 'dist';

gulp.task('clean', function(cb) {
    del.sync('dist');
    cb();
});

gulp.task('build:fonts', function(cb) {
    if (!isDevEnv) {
        return gulp.src('fonts/**').pipe(gulp.dest(outputDir + '/fonts'))
    }
    cb();
});

gulp.task('build:image', function(cb) {
    if (!isDevEnv) {
//    return gulp.src('img/**').pipe(imagemin({
//            progressive: true,
//            use: [pngquant()]
//          }))
//          .pipe(gulp.dest(outputDir + '/img'))
        return gulp.src('img/**').pipe(gulp.dest(outputDir + '/img'))
    }
    cb();
});

gulp.task('build:css', function(cb) {
    if(!isDevEnv) {
        return gulp.src('css/**').pipe(gulp.dest(outputDir + '/css'));
    }
    cb();
});

gulp.task('build:sass', ['build:fonts','build:image'], function() {
    var sassConf = {
        style: 'expanded',
        sourcemap: true
    };
    var stream;
    if(isDevEnv) {
        stream = sass('scss', sassConf).pipe(sourcemaps.write());
    } else {
        // 生产环境css压缩且不输出sourcemap
        sassConf.style = 'compressed';
        sassConf.sourcemap = false;
        stream = sass('scss/', sassConf);
    }
    return stream.pipe(gulp.dest(outputDir + '/css'));
});

gulp.task('build:js', function (cb) {
    if (isDevEnv) {
        // 开发环境不处理
        cb();
    } else {
        // prod环境需要压缩, local, qa环境不压缩
        var stream = gulp.src(['js/**/*.js']);
        if (isProdEnv) {
            stream = stream.pipe(uglify());
        }
        return stream.pipe(gulp.dest(outputDir + '/js'));
    }
});

gulp.task('watch', function() {
    gulp.task('watch', function() {
        // watch for sass files
        gulp.watch('scss/**/*.scss', ['build:sass']);

        // watch for javascript files
        gulp.watch('js/**/*.js', ['build:js']);

        // watch for images files
        gulp.watch('img/**', ['build:img']);

    });
});

gulp.task('build', ['clean'], function() {
    gulp.start(['build:css', 'build:sass', 'build:js']);
});

gulp.task('default', ['build']);


