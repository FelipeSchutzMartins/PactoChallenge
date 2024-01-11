FROM node:21-alpine as node

RUN mkdir /pacto-front
WORKDIR /pacto-front
COPY . /pacto-front

RUN npm install
RUN npm install -g @angular/cli@17

CMD ["ng", "serve", "--host", "0.0.0.0"]