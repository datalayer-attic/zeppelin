/**
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. See accompanying LICENSE file.
 */
package io.datalayer.spitfire.servlet;

// import io.datalayer.spitfire.domain.User;
// import io.datalayer.spitfire.session.SpitfireSessions;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.text.MessageFormat;

public class WhoServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/plain");
    resp.setStatus(HttpServletResponse.SC_OK);
    String user = req.getRemoteUser();
    String principal = (req.getUserPrincipal() != null) ? req.getUserPrincipal().getName() : null;
    Writer writer = resp.getWriter();
    writer.write(MessageFormat.format("Hello user[{0}] principal[{1} sessionid[{2}]", user, principal, req.getSession().getId()));
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }
/*
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/plain");
    resp.setStatus(HttpServletResponse.SC_OK);
    String user = req.getRemoteUser();
    Principal principal = req.getUserPrincipal();
    if(principal instanceof SpnegoPrincipal) {
      SpnegoPrincipal spnegoPrincipal = (SpnegoPrincipal) principal;
      SpnegoLogonInfo logonInfo = spnegoPrincipal.getLogonInfo();
      if(logonInfo != null) {
        String[] groupSIDs = logonInfo.getGroupSids();
        resp.getWriter().println("Found group SIDs: " + Arrays.toString(groupSIDs));
      } else {
        resp.getWriter().println("No logon info available for principal.");
      }
    }
    String principalString = (req.getUserPrincipal() != null) ? req.getUserPrincipal().getName() : null;
    Writer writer = resp.getWriter();
    writer.write(MessageFormat.format("You are: user[{0}] principal[{1}] sessionid[{2}]\n", user, principalString, req.getSession().getId()));
  }
*/
/*
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/plain");
    resp.setStatus(HttpServletResponse.SC_OK);
    String user = req.getRemoteUser();
    String principal = (req.getUserPrincipal() != null) ? req.getUserPrincipal().getName() : null;
    String jsessionid = req.getSession().getId();
    LOGGER.debug("User: " + user + " - Principal:" + principal + " - jsessionid: " + jsessionid);
    if (principal != null) {
      User kerberosUser = new User();
      kerberosUser.setUserName(principal);
      kerberosUser.setDisplayName(principal);
      SpitfireSessions.login(req, kerberosUser);
    }
    Writer writer = resp.getWriter();
    writer.write(MessageFormat.format("You are: user[{0}] principal[{1}] jsessionid[{2}}\n", user, principal, jsessionid));
  }
*/
}
