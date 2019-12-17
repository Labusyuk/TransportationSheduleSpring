package com.labus.transportation.service;

import com.labus.transportation.model.User;
import com.labus.transportation.repositories.UserRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceTest {
    @MockBean
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @Test
    void checkUsefulUsername() {
        User user1 = new User();
        user1.setUsername("userName");
        Mockito.doReturn(user1).when(userRepository).findByUsername("userName");
        Assert.assertEquals(user1.getUsername(),userService.loadUserByUsername("userName").getUsername());
        verify(userRepository).findByUsername("userName");

    }

    @Test
    void checkUsefulEmail() {
        User user1 = new User();
        user1.setEmail("usefulEmail");
        Mockito.doReturn(user1).when(userRepository).findByEmail("usefulEmail");
        Assert.assertEquals(user1,userService.findByEmail("usefulEmail"));
        verify(userRepository).findByEmail("usefulEmail");
    }

    @Test
    void save() {
        User user = new User();
        user.setId(10);
        Mockito.doReturn(user).when(userRepository).save(user);
        Assert.assertTrue(userService.save(user)==user.getId());
        verify(userRepository).save(any());
    }

    @Test
    void addFailled() {
        UserService userService = spy(this.userService);
        User user = new User();
        user.setUsername("usefulName");
        Mockito.doReturn(user).when(userRepository).findByUsername("usefulName");
        Assert.assertFalse(userService.add(user));

    }
    @Test
    void add() {
        UserService userService = spy(this.userService);
        User user = new User();
        //user.setId(0);
        user.setUsername("usefulName");
        Mockito.doReturn(null).when(userRepository).findByUsername("usefulName");
        Mockito.doReturn(user).when(userRepository).save(user);
/*        Mockito.doReturn(any()).when(userRepository).save(any());*/
        Assert.assertTrue(userService.add(user));
        Assert.assertTrue(user.isEnabled());
        Assert.assertTrue(user.isCredentialsNonExpired());
        Assert.assertTrue(user.isAccountNonExpired());
        Assert.assertTrue(user.isAccountNonLocked());
        verify(userRepository).save(user);
        verify(userService).save(user);
    }

    @Test
    void getUserCount() {
        Mockito.doReturn((long)10).when(userRepository).count();
        Assert.assertEquals(Long.valueOf(10),userService.getUserCount());
        verify(userRepository).count();
    }

    @Test
    void findByGoogleUsername() {
        User user1 = new User();
        user1.setGoogleUsername("userName");
        Mockito.doReturn(user1).when(userRepository).findByGoogleUsername("userName");
        Assert.assertEquals(user1.getGoogleUsername(),userService.findByGoogleUsername("userName").getGoogleUsername());
        verify(userRepository).findByGoogleUsername("userName");
    }
}