FROM ruby:2.6.4-alpine
ENV INSTALL_PATH /app

# set up image working directory
RUN mkdir ${INSTALL_PATH}
WORKDIR ${INSTALL_PATH}

# install virtual OS libs for build , install ruby gems then remove build dependencies after build
RUN apk add --no-cache --virtual .build-deps alpine-sdk nodejs sqlite sqlite-dev sqlite-libs tzdata yarn npm

# copy gem files required by the application
COPY Gemfile Gemfile.lock ${INSTALL_PATH}/
COPY package.json ${INSTALL_PATH}/

# remove copied node_modules so as not to cause any conflicts later
RUN rm -rf node_modules/

# Set Rails environment variables
ENV RAILS_ENV development
ENV RACK_ENV development
ENV NODE_ENV development

RUN gem install bundler -v '2.1.4'
RUN bundle -v
RUN bundle install --jobs 20 --retry 5 --deployment

RUN yarn install --production --non-interactive --frozen-lockfile

# add application code to image
COPY . ${INSTALL_PATH}/

RUN rm -rf tmp/* log/*

EXPOSE 3000 3000
CMD ["sh", "-c", "rm -f tmp/pids/server.pid && bundle exec rails server -b 0.0.0.0"]
