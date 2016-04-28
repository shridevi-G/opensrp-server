package org.ei.drishti.reporting.controller;

import com.google.gson.Gson;
import org.ei.drishti.common.domain.UserDetail;
import org.ei.drishti.common.util.HttpAgent;
import org.ei.drishti.common.util.HttpResponse;
import org.ei.drishti.dto.ANMDTO;
import org.ei.drishti.dto.LocationDTO;
import org.ei.drishti.reporting.domain.Location;
import org.ei.drishti.reporting.domain.SP_ANM;
import org.ei.drishti.reporting.factory.DetailsFetcherFactory;
import org.ei.drishti.reporting.service.ANMService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static java.util.Arrays.asList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class ANMControllerTest {

    @Mock
    private ANMService anmService;
    @Mock
    private Location location;
    @Mock
    private HttpAgent httpAgent;
    @Mock
    private DetailsFetcherFactory detailsFetcherFactory;
    @Mock
    private ANMDetailsFetcher anmDetailsFetcher;
    private ANMController controller;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        controller = new ANMController("site-url", "http://user-details-endpoint/user-details", anmService, httpAgent, detailsFetcherFactory);
    }

    @Test
    public void shouldReturnListOfANMs() throws Exception {
        List<String> roles = asList("ROLE_USER");
        when(httpAgent.get("http://user-details-endpoint/user-details?anm-id=username1")).
                thenReturn(new HttpResponse(true,
                                new Gson().toJson(new UserDetail("username1", roles))));

        when(detailsFetcherFactory.detailsFetcher(roles)).thenReturn(anmDetailsFetcher);
        when(anmDetailsFetcher.fetchDetails("username1")).thenReturn(asList(
                new SP_ANM("username1", "user1 name", "Sub Center 1", 0),
                new SP_ANM("username2", "user2 name", "Sub Center 1", 0)
        ));
        when(location.district()).thenReturn("district");
        when(location.phcName()).thenReturn("phc");
        when(location.state()).thenReturn("state");
        when(location.taluka()).thenReturn("taluka");
        when(location.village()).thenReturn("village");
        when(location.subCenter()).thenReturn("subcenter");

        when(anmService.getLocation("username1")).thenReturn(location);
        when(anmService.getLocation("username2")).thenReturn(location);

        ResponseEntity<List<ANMDTO>> response = controller.all("username1");
        LocationDTO locationDTO = new LocationDTO(location.subCenter(), location.phcName(), location.taluka(), location.district(), location.state());
        assertEquals(asList(new ANMDTO("username1", "user1 name", locationDTO), new ANMDTO("username2", "user2 name", locationDTO)), response.getBody());
    }
}
