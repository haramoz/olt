/*
 * Copyright 2016-present Open Networking Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.opencord.olt.cli;

import org.apache.karaf.shell.api.action.Command;
import org.apache.karaf.shell.api.action.lifecycle.Service;
import org.onlab.packet.VlanId;
import org.onosproject.cli.AbstractShellCommand;
import org.onosproject.net.ConnectPoint;
import org.opencord.olt.AccessDeviceService;

import java.util.Map;

/**
 * Shows provisioned (configured) subscribers. The data plane flows for the
 * subscribers may or may not have been programmed.
 */
@Service
@Command(scope = "onos", name = "volt-subscribers",
        description = "Shows pre-provisioned subscribers")
public class ShowSubscribersCommand extends AbstractShellCommand {

    private static final String FORMAT = "port=%s, svlan=%s, cvlan=%s";

    @Override
    protected void doExecute() {
        AccessDeviceService service = AbstractShellCommand.get(AccessDeviceService.class);
        service.getSubscribers().forEach(this::display);
    }

    private void display(Map.Entry<ConnectPoint, Map.Entry<VlanId, VlanId>> subscriber) {
        print(FORMAT, subscriber.getKey(), subscriber.getValue().getKey(),
                subscriber.getValue().getValue());
    }
}
