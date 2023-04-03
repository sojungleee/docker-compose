FROM node:lts-alpine

WORKDIR /app

COPY package.json .

ADD . .

RUN npm install

CMD [ "npm", "run", "serve" ]