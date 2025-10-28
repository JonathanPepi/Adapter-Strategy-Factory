package com.agencia.core;

import com.agencia.adapters.InstagramAdapter;
import com.agencia.adapters.LinkedInAdapter;
import com.agencia.adapters.TwitterAdapter;
import com.agencia.external.InstagramAPI;
import com.agencia.external.LinkedInAPI;
import com.agencia.external.TwitterAPI;

/**
 * (Tarefa 3: Social Media Factory)
 * Esta classe usa o padrão Factory Method para criar o Adapter (Strategy) correto
 * com base na plataforma e na configuração.
 */
public class SocialMediaFactory {

    // Este é o "Factory Method"
    public ISocialMediaAdapter criarAdapter(Plataforma plataforma, Configuracao config) {
        
        switch (plataforma) {
            case TWITTER:
                // A fábrica é responsável por criar a API real e injetá-la no Adapter
                String twitterKey = config.getProperty("TWITTER_API_KEY");
                TwitterAPI twitterAPI = new TwitterAPI(twitterKey);
                return new TwitterAdapter(twitterAPI);
                
            case INSTAGRAM:
                String instaToken = config.getProperty("INSTAGRAM_ACCESS_TOKEN");
                InstagramAPI instagramAPI = new InstagramAPI(instaToken);
                return new InstagramAdapter(instagramAPI);

            case LINKEDIN:
                String linkedInId = config.getProperty("LINKEDIN_CLIENT_ID");
                String linkedInSecret = config.getProperty("LINKEDIN_CLIENT_SECRET");
                LinkedInAPI linkedInAPI = new LinkedInAPI(linkedInId, linkedInSecret);
                return new LinkedInAdapter(linkedInAPI);
            
            default:
                throw new IllegalArgumentException("Plataforma não suportada: " + plataforma);
        }
    }
}