package dao;

import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import utils.CifradoCesar;

import java.io.IOException;

public class TestInterceptor implements Interceptor {
  @NotNull
  @Override
  public Response intercept(@NotNull Chain chain) throws IOException {

    CifradoCesar cf = new CifradoCesar();
    Request r = chain.request();

    //chain get
    HttpUrl.Builder builder = r.url()
        .newBuilder();
    r.url().queryParameterNames().stream().forEach(name -> {
      builder.addQueryParameter(name, cf.cifra(r.url().queryParameter(name), 1));
    });


    FormBody.Builder formBuilder = new FormBody.Builder();
    for (int i = 0; i < ((FormBody) r.body()).size(); i++) {
      formBuilder.add(((FormBody) r.body()).name(i), cf.cifra(((FormBody) r.body()).value(i), 1));
    }
    Request.Builder requestCodificado = r
        .newBuilder()
        .url(builder.build());

    if (r.method().equals("POST")) {
      requestCodificado.post(formBuilder.build());
    }
    Response retorno = chain.proceed(requestCodificado.build());
    MediaType contentType = retorno.body().contentType();
    ResponseBody body = ResponseBody.create(cf.descifra(retorno.body().string(), 1), contentType);
    return retorno.newBuilder().body(body).build();
  }
}
