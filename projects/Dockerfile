# Stage 1: Build Angular application
FROM node:18-alpine as build-stage

WORKDIR /app

COPY package*.json /app/

RUN npm install --force

COPY . .

RUN npm run build --prod

# Stage 2: Serve Angular application using Nginx
FROM httpd:alpine3.15

WORKDIR /usr/local/apache2/htdocs

COPY --from=build-stage /app/dist/projects .

