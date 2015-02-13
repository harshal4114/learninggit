/**
 *
 */
package com.wikia.webdriver.testcases.mediatests.addvideo;

import com.wikia.webdriver.common.contentpatterns.VideoContent;
import com.wikia.webdriver.common.core.YoutubeVideo;
import com.wikia.webdriver.common.core.YoutubeVideoProvider;
import com.wikia.webdriver.common.properties.Credentials;
import com.wikia.webdriver.common.templates.NewTestTemplate;
import com.wikia.webdriver.pageobjectsfactory.componentobject.vet.VetAddVideoComponentObject;
import com.wikia.webdriver.pageobjectsfactory.pageobject.special.SpecialVideosPageObject;

import org.testng.annotations.Test;

/**
 * @author Karol 'kkarolk' Kujawiak
 */
public class VetSpecialVideosTests extends NewTestTemplate {

  Credentials credentials = config.getCredentials();

  @Test(groups = {"VetTests001", "VetTests", "SpecialVideo", "Media"})
  public void SpecialVideos_001_Provider() {
    YoutubeVideo video = YoutubeVideoProvider.getLatestVideoForQuery("lol");

    SpecialVideosPageObject specialVideos = new SpecialVideosPageObject(driver);
    specialVideos.logInCookie(credentials.userName, credentials.password, wikiURL);
    specialVideos.openSpecialVideoPage(wikiURL);
    VetAddVideoComponentObject vetAddingVideo = specialVideos.clickAddAVideo();
    vetAddingVideo.addVideoByUrl(video.getUrl());
    specialVideos.verifyVideoAdded(video.getTitle());
  }

  @Test(enabled = false, groups = {"VetTests002", "VetTests", "SpecialVideo", "Media"})
  public void SpecialVideos_002_Library() {
    SpecialVideosPageObject specialVideos = new SpecialVideosPageObject(driver);
    specialVideos.logInCookie(credentials.userName, credentials.password, wikiURL);
    specialVideos.openSpecialVideoPage(wikiURL);
    VetAddVideoComponentObject vetAddingVideo = specialVideos.clickAddAVideo();
    vetAddingVideo.addVideoByQuery(VideoContent.WIKIA_VIDEO_QUERY, 0);
    specialVideos.verifyVideoAdded(vetAddingVideo.getVideoName());
  }

}
